// Command Pattern – Kotlin Template

interface Command { fun execute(); fun undo() }

class Receiver { fun action(){ /* do something */ }; fun undoAction(){ /* undo something */ } }

class ConcreteCommand(private val r: Receiver) : Command {
    override fun execute() = r.action()
    override fun undo() = r.undoAction()
}

class Invoker { private var cmd: Command? = null; fun set(c: Command){ cmd = c }; fun run(){ cmd?.execute() }; fun undo(){ cmd?.undo() } }

fun main(){ val inv = Invoker(); inv.set(ConcreteCommand(Receiver())); inv.run(); inv.undo() }
