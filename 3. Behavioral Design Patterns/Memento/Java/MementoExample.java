// Memento Pattern Example in Java
// Text editor that can save and restore document states

import java.util.*;

class TextMemento {
    private final String content;
    public TextMemento(String content) { this.content = content; }
    public String getContent() { return content; }
}

class TextEditor {
    private String content = "";
    public void write(String text) { content += text; }
    public void clear() { content = ""; }
    public String getContent() { return content; }
    public TextMemento save() { return new TextMemento(content); }
    public void restore(TextMemento memento) { content = memento.getContent(); }
}

class EditorHistory {
    private final Stack<TextMemento> history = new Stack<>();
    public void save(TextEditor editor) { history.push(editor.save()); }
    public void undo(TextEditor editor) { if (!history.isEmpty()) editor.restore(history.pop()); }
}

public class MementoExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.write("Hello ");
        history.save(editor);
        System.out.println("Content: " + editor.getContent());

        editor.write("World!");
        history.save(editor);
        System.out.println("Content: " + editor.getContent());

        history.undo(editor);
        System.out.println("After undo: " + editor.getContent());

        history.undo(editor);
        System.out.println("After undo: " + editor.getContent());
    }
}
