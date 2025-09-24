// Memento Pattern Example in C#
// Text editor that can save and restore document states

using System;
using System.Collections.Generic;

namespace MementoExample
{
    class TextMemento
    {
        public string Content { get; }
        public TextMemento(string content) { Content = content; }
    }

    class TextEditor
    {
        private string content = "";
        public void Write(string text) { content += text; }
        public void Clear() { content = ""; }
        public string GetContent() => content;
        public TextMemento Save() => new TextMemento(content);
        public void Restore(TextMemento memento) { content = memento.Content; }
    }

    class EditorHistory
    {
        private readonly Stack<TextMemento> history = new();
        public void Save(TextEditor editor) { history.Push(editor.Save()); }
        public void Undo(TextEditor editor) { if (history.Count > 0) editor.Restore(history.Pop()); }
    }

    class Program
    {
        static void Main()
        {
            var editor = new TextEditor();
            var history = new EditorHistory();

            editor.Write("Hello ");
            history.Save(editor);
            Console.WriteLine("Content: " + editor.GetContent());

            editor.Write("World!");
            history.Save(editor);
            Console.WriteLine("Content: " + editor.GetContent());

            history.Undo(editor);
            Console.WriteLine("After undo: " + editor.GetContent());

            history.Undo(editor);
            Console.WriteLine("After undo: " + editor.GetContent());
        }
    }
}
