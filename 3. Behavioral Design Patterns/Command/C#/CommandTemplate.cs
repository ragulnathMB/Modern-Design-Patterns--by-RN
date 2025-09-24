// Command Pattern – C# Template

namespace CommandTemplate
{
    interface ICommand { void Execute(); void Undo(); }

    class Receiver { public void Action(){ /* do something */ } public void UndoAction(){ /* undo something */ } }

    class ConcreteCommand : ICommand
    {
        private readonly Receiver _r;
        public ConcreteCommand(Receiver r){ _r = r; }
        public void Execute(){ _r.Action(); }
        public void Undo(){ _r.UndoAction(); }
    }

    class Invoker { private ICommand _cmd; public void Set(ICommand c){ _cmd = c; } public void Run(){ _cmd?.Execute(); } public void Undo(){ _cmd?.Undo(); } }

    class Program { static void Main(){ var r = new Receiver(); var c = new ConcreteCommand(r); var inv = new Invoker(); inv.Set(c); inv.Run(); inv.Undo(); } }
}
