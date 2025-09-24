// Mediator Pattern – Kotlin Template

interface Mediator { fun notify(sender: Any, eventType: String) }

abstract class Colleague(protected val mediator: Mediator) {
    abstract fun doSomething()
}

class ConcreteColleagueA(mediator: Mediator) : Colleague(mediator) {
    override fun doSomething() = mediator.notify(this, "EventA")
}

class ConcreteColleagueB(mediator: Mediator) : Colleague(mediator) {
    override fun doSomething() = mediator.notify(this, "EventB")
}

class ConcreteMediator : Mediator {
    private val colleagues = mutableListOf<Colleague>()
    fun addColleague(colleague: Colleague) = colleagues.add(colleague).let {}
    override fun notify(sender: Any, eventType: String) { /* handle event */ }
}

fun main() {
    val mediator = ConcreteMediator()
    val colleagueA = ConcreteColleagueA(mediator)
    val colleagueB = ConcreteColleagueB(mediator)
    mediator.addColleague(colleagueA)
    mediator.addColleague(colleagueB)
    colleagueA.doSomething()
}
