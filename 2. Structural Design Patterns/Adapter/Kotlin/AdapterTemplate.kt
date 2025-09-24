// Adapter Pattern – Kotlin Template
// Target expects request(); Adaptee has specificRequest(); Adapter bridges them.

interface Target { fun request() }
class Adaptee { fun specificRequest() { /* ... */ } }
class Adapter(private val adaptee: Adaptee = Adaptee()) : Target { override fun request() = adaptee.specificRequest() }

fun main(){ val t: Target = Adapter(); t.request() }
