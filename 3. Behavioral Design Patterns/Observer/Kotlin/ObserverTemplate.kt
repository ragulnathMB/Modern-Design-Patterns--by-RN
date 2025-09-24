// Observer Pattern – Kotlin Template

interface Observer { fun update() }
interface Subject { fun attach(o: Observer); fun detach(o: Observer); fun notify() }

class ConcreteSubject : Subject {
    private val observers = mutableListOf<Observer>()
    override fun attach(o: Observer) = observers.add(o).let{}
    override fun detach(o: Observer) = observers.remove(o).let{}
    override fun notify() = observers.forEach { it.update() }
    fun doSomething() { /* change state */ notify() }
}

class ConcreteObserver : Observer { override fun update() { /* react to change */ } }

fun main(){ val s = ConcreteSubject(); s.attach(ConcreteObserver()); s.doSomething() }
