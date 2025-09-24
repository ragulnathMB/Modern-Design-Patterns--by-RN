package main

import "fmt"

// Memento Pattern Example in Go
// Text editor that can save and restore document states

type TextMemento struct {
	content string
}

func NewTextMemento(content string) *TextMemento {
	return &TextMemento{content: content}
}

func (m *TextMemento) GetContent() string {
	return m.content
}

type TextEditor struct {
	content string
}

func NewTextEditor() *TextEditor {
	return &TextEditor{content: ""}
}

func (e *TextEditor) Write(text string) {
	e.content += text
}

func (e *TextEditor) Clear() {
	e.content = ""
}

func (e *TextEditor) GetContent() string {
	return e.content
}

func (e *TextEditor) Save() *TextMemento {
	return NewTextMemento(e.content)
}

func (e *TextEditor) Restore(memento *TextMemento) {
	e.content = memento.GetContent()
}

type EditorHistory struct {
	history []*TextMemento
}

func NewEditorHistory() *EditorHistory {
	return &EditorHistory{history: make([]*TextMemento, 0)}
}

func (h *EditorHistory) Save(editor *TextEditor) {
	h.history = append(h.history, editor.Save())
}

func (h *EditorHistory) Undo(editor *TextEditor) {
	if len(h.history) > 0 {
		memento := h.history[len(h.history)-1]
		h.history = h.history[:len(h.history)-1]
		editor.Restore(memento)
	}
}

func main() {
	editor := NewTextEditor()
	history := NewEditorHistory()

	editor.Write("Hello ")
	history.Save(editor)
	fmt.Println("Content:", editor.GetContent())

	editor.Write("World!")
	history.Save(editor)
	fmt.Println("Content:", editor.GetContent())

	history.Undo(editor)
	fmt.Println("After undo:", editor.GetContent())

	history.Undo(editor)
	fmt.Println("After undo:", editor.GetContent())
}
