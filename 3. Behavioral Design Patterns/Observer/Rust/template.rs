// Observer Pattern – Rust Template

trait Observer { fn update(&self); }

struct ConcreteSubject { observers: Vec<Box<dyn Observer>> }
impl ConcreteSubject {
    fn new() -> Self { Self { observers: Vec::new() } }
    fn attach(&mut self, o: Box<dyn Observer>) { self.observers.push(o) }
    fn notify(&self) { for o in &self.observers { o.update() } }
    fn do_something(&self) { /* change state */ self.notify() }
}

struct ConcreteObserver;
impl Observer for ConcreteObserver { fn update(&self) { /* react to change */ } }

fn main(){ let mut s = ConcreteSubject::new(); s.attach(Box::new(ConcreteObserver)); s.do_something() }
