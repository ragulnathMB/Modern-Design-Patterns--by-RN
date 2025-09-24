// Facade Pattern – Kotlin Template

class SubsystemA { fun opA(){ /* ... */ } }
class SubsystemB { fun opB(){ /* ... */ } }
class SubsystemC { fun opC(){ /* ... */ } }

class Facade { private val a=SubsystemA(); private val b=SubsystemB(); private val c=SubsystemC(); fun doWork(){ a.opA(); b.opB(); c.opC() } }

fun main(){ Facade().doWork() }
