// Command Pattern – Java Template

interface Command { void execute(); void undo(); }

class Receiver { void action(){ /* do something */ } void undoAction(){ /* undo something */ } }

class ConcreteCommand implements Command {
    private final Receiver r;
    ConcreteCommand(Receiver r){ this.r = r; }
    public void execute(){ r.action(); }
    public void undo(){ r.undoAction(); }
}

class Invoker { private Command cmd; void set(Command c){ cmd = c; } void run(){ if (cmd != null) cmd.execute(); } void undo(){ if (cmd != null) cmd.undo(); } }

public class CommandTemplate { public static void main(String[] args){ Invoker i = new Invoker(); i.set(new ConcreteCommand(new Receiver())); i.run(); i.undo(); } }
