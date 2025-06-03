#include <iostream>
#include <string>
#include <vector>
using namespace std;

// Memento class
class Memento {
private:
    string content;

public:
    Memento(const string& text) : content(text) {}
    string getContent() const { return content; }
};

// Originator: TextEditor
class TextEditor {
private:
    string content;

public:
    void type(const string& words) {
        content += words;
    }

    void show() const {
        cout << "Current Content: " << content << endl;
    }

    Memento save() {
        return Memento(content);
    }

    void restore(const Memento& m) {
        content = m.getContent();
    }
};

// Caretaker: History manager
class History {
private:
    vector<Memento> history;

public:
    void save(const Memento& m) {
        history.push_back(m);
    }

    Memento undo() {
        if (!history.empty()) {
            Memento m = history.back();
            history.pop_back();
            return m;
        }
        return Memento("");  // return empty if no history
    }

    bool hasUndo() const {
        return !history.empty();
    }
};

int main() {
    TextEditor editor;
    History history;

    editor.type("Hello ");
    history.save(editor.save()); // Save after typing Hello

    editor.type("World!");
    history.save(editor.save()); // Save after typing World

    editor.show(); // Shows: Hello World!

    // Undo last change
    if (history.hasUndo()) {
        editor.restore(history.undo());
        editor.show(); // Shows: Hello 
    }

    return 0;
}
