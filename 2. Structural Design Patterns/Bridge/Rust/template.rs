// Bridge Pattern – Rust Template
// Separate Abstraction from Implementor so they can vary independently.

trait Implementor { fn op_impl(&self); }
struct ConcreteImplA;
impl Implementor for ConcreteImplA { fn op_impl(&self) { /* ... */ } }

struct Abstraction<I: Implementor> { implr: I }
impl<I: Implementor> Abstraction<I> {
    fn operation(&self) { self.implr.op_impl(); }
}

struct RefinedAbstraction<I: Implementor>(Abstraction<I>);

fn main(){ let a = RefinedAbstraction(Abstraction{ implr: ConcreteImplA }); a.0.operation(); }
