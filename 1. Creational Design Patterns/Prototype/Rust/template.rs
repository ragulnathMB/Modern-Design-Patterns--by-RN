// Prototype Pattern – Rust Template
#[derive(Clone)]
pub struct ConcretePrototype { pub data: i32 }

pub trait Prototype {
    fn clone_box(&self) -> Box<dyn Prototype>;
}

impl Prototype for ConcretePrototype {
    fn clone_box(&self) -> Box<dyn Prototype> { Box::new(self.clone()) }
}

fn main() {
    let original = ConcretePrototype { data: 42 };
    let _copy = original.clone_box();
}
