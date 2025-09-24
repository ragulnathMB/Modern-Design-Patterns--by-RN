// State Pattern – TypeScript Template

interface State { handle(context: Context): void }
class Context { constructor(private state: State){} setState(s: State){ this.state = s } request(){ this.state.handle(this) } }
class ConcreteStateA implements State { handle(c: Context){ /* work */ c.setState(new ConcreteStateB()) } }
class ConcreteStateB implements State { handle(c: Context){ /* work */ c.setState(new ConcreteStateA()) } }
;(function main(){ const c = new Context(new ConcreteStateA()); c.request(); c.request() })()

export {}
