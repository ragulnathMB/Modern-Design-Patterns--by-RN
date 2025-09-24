// Abstract Factory Pattern – Rust Template

pub trait ProductA {}
pub trait ProductB {}

pub struct ConcreteProductA1;
impl ProductA for ConcreteProductA1 {}

pub struct ConcreteProductB1;
impl ProductB for ConcreteProductB1 {}

pub trait AbstractFactory {
    fn create_product_a(&self) -> Box<dyn ProductA>;
    fn create_product_b(&self) -> Box<dyn ProductB>;
}

pub struct ConcreteFactory1;
impl AbstractFactory for ConcreteFactory1 {
    fn create_product_a(&self) -> Box<dyn ProductA> { Box::new(ConcreteProductA1) }
    fn create_product_b(&self) -> Box<dyn ProductB> { Box::new(ConcreteProductB1) }
}

fn main() {
    let factory = ConcreteFactory1;
    // let product_a = factory.create_product_a();
}
