// Proxy Pattern – Kotlin Template

interface Subject { fun request() }
class RealSubject : Subject { override fun request() { /* heavy work */ } }
class Proxy : Subject { private var real: RealSubject? = null; override fun request(){ if (real == null) real = RealSubject(); /* checks/logging */ real!!.request() } }
fun main(){ val s: Subject = Proxy(); s.request() }
