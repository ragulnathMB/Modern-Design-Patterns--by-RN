// State Pattern – JavaScript Template

class State { handle(context){} }
class Context { constructor(s){ this.state = s } setState(s){ this.state = s } request(){ this.state.handle(this) } }
class ConcreteStateA extends State { handle(c){ /* work */ c.setState(new ConcreteStateB()) } }
class ConcreteStateB extends State { handle(c){ /* work */ c.setState(new ConcreteStateA()) } }
;(function main(){ const c = new Context(new ConcreteStateA()); c.request(); c.request() })()
