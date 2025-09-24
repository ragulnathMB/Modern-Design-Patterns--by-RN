// Memento Pattern Example in JavaScript
// Text editor that can save and restore document states

class TextMemento {
  constructor(content) { this.content = content }
  getContent() { return this.content }
}

class TextEditor {
  constructor() { this.content = '' }
  write(text) { this.content += text }
  clear() { this.content = '' }
  getContent() { return this.content }
  save() { return new TextMemento(this.content) }
  restore(memento) { this.content = memento.getContent() }
}

class EditorHistory {
  constructor() { this.history = [] }
  save(editor) { this.history.push(editor.save()) }
  undo(editor) { if (this.history.length > 0) editor.restore(this.history.pop()) }
}

;(function main() {
  const editor = new TextEditor()
  const history = new EditorHistory()

  editor.write('Hello ')
  history.save(editor)
  console.log('Content:', editor.getContent())

  editor.write('World!')
  history.save(editor)
  console.log('Content:', editor.getContent())

  history.undo(editor)
  console.log('After undo:', editor.getContent())

  history.undo(editor)
  console.log('After undo:', editor.getContent())
})()
