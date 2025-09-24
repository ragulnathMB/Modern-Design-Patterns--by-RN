// Builder Pattern – Rust Template
pub struct Product;
pub trait Builder {
    fn build_part_a(&mut self);
    fn build_part_b(&mut self);
    fn get_result(&self) -> &Product;
}

pub struct ConcreteBuilder { product: Product }
impl ConcreteBuilder { pub fn new() -> Self { Self{ product: Product } } }
impl Builder for ConcreteBuilder {
    fn build_part_a(&mut self) {}
    fn build_part_b(&mut self) {}
    fn get_result(&self) -> &Product { &self.product }
}

pub struct Director;
impl Director {
    pub fn construct<B: Builder>(builder: &mut B) {
        builder.build_part_a();
        builder.build_part_b();
    }
}

fn main() { let mut b = ConcreteBuilder::new(); Director::construct(&mut b); }
