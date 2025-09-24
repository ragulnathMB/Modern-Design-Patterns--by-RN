// Memento Pattern – C# Template

using System.Collections.Generic;

namespace MementoTemplate
{
    class Memento
    {
        public string State { get; }
        public Memento(string state) { State = state; }
    }

    class Originator
    {
        private string state;
        public void SetState(string state) { this.state = state; }
        public string GetState() => state;
        public Memento CreateMemento() => new Memento(state);
        public void RestoreMemento(Memento memento) { state = memento.State; }
    }

    class Caretaker
    {
        private readonly Stack<Memento> mementos = new();
        public void SaveState(Originator originator) { mementos.Push(originator.CreateMemento()); }
        public void RestoreState(Originator originator) { if (mementos.Count > 0) originator.RestoreMemento(mementos.Pop()); }
    }

    class Program
    {
        static void Main()
        {
            var originator = new Originator();
            var caretaker = new Caretaker();
            originator.SetState("State1");
            caretaker.SaveState(originator);
            originator.SetState("State2");
            caretaker.RestoreState(originator);
        }
    }
}
