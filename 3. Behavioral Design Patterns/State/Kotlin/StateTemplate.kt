// State Pattern – Kotlin Template

interface State { fun handle(context: Context) }
class Context(private var state: State) { fun setState(s: State){ state = s }; fun request(){ state.handle(this) } }
class ConcreteStateA : State { override fun handle(c: Context){ /* work */ c.setState(ConcreteStateB()) } }
class ConcreteStateB : State { override fun handle(c: Context){ /* work */ c.setState(ConcreteStateA()) } }
fun main(){ val c = Context(ConcreteStateA()); c.request(); c.request() }
