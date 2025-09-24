// Memento Pattern Example in TypeScript
// Text editor that can save and restore document states

class TextMemento {
  constructor(private content: string) {}
  getContent(): string { return this.content }
}

class TextEditor {
  private content = ''
  write(text: string): void { this.content += text }
  clear(): void { this.content = '' }
  getContent(): string { return this.content }
  save(): TextMemento { return new TextMemento(this.content) }
  restore(memento: TextMemento): void { this.content = memento.getContent() }
}

class EditorHistory {
  private history: TextMemento[] = []
  save(editor: TextEditor): void { this.history.push(editor.save()) }
  undo(editor: TextEditor): void { if (this.history.length > 0) editor.restore(this.history.pop()!) }
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

export {}
