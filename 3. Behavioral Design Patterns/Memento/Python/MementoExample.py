# Memento Pattern Example in Python
# Text editor that can save and restore document states

class TextMemento:
    def __init__(self, content):
        self._content = content
    
    def get_content(self):
        return self._content

class TextEditor:
    def __init__(self):
        self._content = ""
    
    def write(self, text):
        self._content += text
    
    def clear(self):
        self._content = ""
    
    def get_content(self):
        return self._content
    
    def save(self):
        return TextMemento(self._content)
    
    def restore(self, memento):
        self._content = memento.get_content()

class EditorHistory:
    def __init__(self):
        self._history = []
    
    def save(self, editor):
        self._history.append(editor.save())
    
    def undo(self, editor):
        if self._history:
            memento = self._history.pop()
            editor.restore(memento)

def main():
    editor = TextEditor()
    history = EditorHistory()
    
    editor.write("Hello ")
    history.save(editor)
    print(f"Content: {editor.get_content()}")
    
    editor.write("World!")
    history.save(editor)
    print(f"Content: {editor.get_content()}")
    
    history.undo(editor)
    print(f"After undo: {editor.get_content()}")
    
    history.undo(editor)
    print(f"After undo: {editor.get_content()}")

if __name__ == "__main__":
    main()
