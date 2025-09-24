// Template Method Pattern – Rust Template

trait AbstractClass {
    fn template_method(&self) {
        self.step_one();
        self.step_two();
        self.hook();
    }
    fn step_one(&self);
    fn step_two(&self);
    fn hook(&self) { /* optional override */ }
}

struct ConcreteClassA;
impl AbstractClass for ConcreteClassA {
    fn step_one(&self) { println!("A: Step 1"); }
    fn step_two(&self) { println!("A: Step 2"); }
}

struct ConcreteClassB;
impl AbstractClass for ConcreteClassB {
    fn step_one(&self) { println!("B: Step 1"); }
    fn step_two(&self) { println!("B: Step 2"); }
    fn hook(&self) { println!("B: Hook"); }
}

fn main() {
    ConcreteClassA.template_method();
    ConcreteClassB.template_method();
}
