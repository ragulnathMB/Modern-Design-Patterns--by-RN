// State Pattern – Rust Template

trait State { fn handle(self: Box<Self>) -> Box<dyn State>; }

struct Context { state: Box<dyn State> }
impl Context {
    fn new(s: Box<dyn State>) -> Self { Self { state: s } }
    fn request(&mut self) { let old = std::mem::replace(&mut self.state, Box::new(ConcreteStateA)); self.state = old.handle(); }
}

struct ConcreteStateA;
impl State for ConcreteStateA { fn handle(self: Box<Self>) -> Box<dyn State> { /* work */ Box::new(ConcreteStateB) } }

struct ConcreteStateB;
impl State for ConcreteStateB { fn handle(self: Box<Self>) -> Box<dyn State> { /* work */ Box::new(ConcreteStateA) } }

fn main(){ let mut c = Context::new(Box::new(ConcreteStateA)); c.request(); c.request(); }
