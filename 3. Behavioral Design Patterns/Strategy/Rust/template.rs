// Strategy Pattern – Rust Template

trait Strategy {
    fn execute(&self, data: &[i32]) -> Vec<i32>;
}

struct ConcreteStrategyA;
impl Strategy for ConcreteStrategyA {
    fn execute(&self, data: &[i32]) -> Vec<i32> { data.to_vec() }
}

struct ConcreteStrategyB;
impl Strategy for ConcreteStrategyB {
    fn execute(&self, data: &[i32]) -> Vec<i32> { data.iter().rev().cloned().collect() }
}

struct Context {
    s: Box<dyn Strategy>,
}

impl Context {
    fn new(s: Box<dyn Strategy>) -> Self { Self { s } }
    fn set(&mut self, s: Box<dyn Strategy>) { self.s = s }
    fn do_work(&self, data: &[i32]) -> Vec<i32> { self.s.execute(data) }
}

fn main() {
    let data = vec![1,2,3];
    let mut ctx = Context::new(Box::new(ConcreteStrategyA));
    println!("{:?}", ctx.do_work(&data));
    ctx.set(Box::new(ConcreteStrategyB));
    println!("{:?}", ctx.do_work(&data));
}
