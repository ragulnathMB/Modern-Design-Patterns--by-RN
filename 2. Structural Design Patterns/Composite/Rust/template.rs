// Composite Pattern – Rust Template

trait Component { fn operation(&self); }
struct Leaf;
impl Component for Leaf { fn operation(&self) { /* ... */ } }

struct Composite { children: Vec<Box<dyn Component>> }
impl Composite {
    fn new() -> Self { Self { children: vec![] } }
    fn add(&mut self, c: Box<dyn Component>) { self.children.push(c) }
}
impl Component for Composite {
    fn operation(&self) { for ch in &self.children { ch.operation(); } }
}

fn main(){ let mut root = Composite::new(); root.add(Box::new(Leaf)); root.operation(); }
