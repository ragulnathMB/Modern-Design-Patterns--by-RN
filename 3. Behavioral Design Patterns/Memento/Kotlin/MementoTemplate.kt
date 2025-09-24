// Memento Pattern – Kotlin Template

data class Memento(val state: String)

class Originator {
    private var state = ""
    fun setState(state: String) { this.state = state }
    fun getState() = state
    fun createMemento() = Memento(state)
    fun restoreMemento(memento: Memento) { state = memento.state }
}

class Caretaker {
    private val mementos = mutableListOf<Memento>()
    fun saveState(originator: Originator) = mementos.add(originator.createMemento())
    fun restoreState(originator: Originator) { if (mementos.isNotEmpty()) originator.restoreMemento(mementos.removeLastOrNull()!!) }
}

fun main() {
    val originator = Originator()
    val caretaker = Caretaker()
    originator.setState("State1")
    caretaker.saveState(originator)
    originator.setState("State2")
    caretaker.restoreState(originator)
}
