// Memento Pattern Example in Rust
// Text editor that can save and restore document states

#[derive(Clone)]
struct TextMemento {
    content: String,
}

impl TextMemento {
    fn new(content: String) -> Self {
        Self { content }
    }

    fn get_content(&self) -> &str {
        &self.content
    }
}

struct TextEditor {
    content: String,
}

impl TextEditor {
    fn new() -> Self {
        Self {
            content: String::new(),
        }
    }

    fn write(&mut self, text: &str) {
        self.content.push_str(text);
    }

    fn clear(&mut self) {
        self.content.clear();
    }

    fn get_content(&self) -> &str {
        &self.content
    }

    fn save(&self) -> TextMemento {
        TextMemento::new(self.content.clone())
    }

    fn restore(&mut self, memento: &TextMemento) {
        self.content = memento.get_content().to_string();
    }
}

struct EditorHistory {
    history: Vec<TextMemento>,
}

impl EditorHistory {
    fn new() -> Self {
        Self {
            history: Vec::new(),
        }
    }

    fn save(&mut self, editor: &TextEditor) {
        self.history.push(editor.save());
    }

    fn undo(&mut self, editor: &mut TextEditor) {
        if let Some(memento) = self.history.pop() {
            editor.restore(&memento);
        }
    }
}

fn main() {
    let mut editor = TextEditor::new();
    let mut history = EditorHistory::new();

    editor.write("Hello ");
    history.save(&editor);
    println!("Content: {}", editor.get_content());

    editor.write("World!");
    history.save(&editor);
    println!("Content: {}", editor.get_content());

    history.undo(&mut editor);
    println!("After undo: {}", editor.get_content());

    history.undo(&mut editor);
    println!("After undo: {}", editor.get_content());
}
