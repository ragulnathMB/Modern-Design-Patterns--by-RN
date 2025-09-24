// Flyweight Pattern Example in Rust
// Forest: shares TreeType (intrinsic) among many Tree instances (extrinsic position)

use std::collections::HashMap;

struct TreeType {
    name: String,
    color: String,
    texture: String,
}

impl TreeType {
    fn new(name: &str, color: &str, texture: &str) -> Self {
        Self { name: name.into(), color: color.into(), texture: texture.into() }
    }
    fn draw(&self, x: i32, y: i32) {
        println!("Draw {} [{},{}] at ({},{})", self.name, self.color, self.texture, x, y);
    }
}

struct TreeFactory {
    cache: HashMap<String, TreeType>,
}

impl TreeFactory {
    fn new() -> Self { Self { cache: HashMap::new() } }
    fn get_tree_type(&mut self, name: &str, color: &str, texture: &str) -> &TreeType {
        let key = format!("{}-{}-{}", name, color, texture);
        self.cache.entry(key).or_insert_with(|| TreeType::new(name, color, texture))
    }
}

struct Tree<'a> {
    x: i32,
    y: i32,
    t: &'a TreeType,
}

impl<'a> Tree<'a> {
    fn draw(&self) { self.t.draw(self.x, self.y); }
}

struct Forest {
    trees: Vec<(i32, i32, String, String, String)>,
}

impl Forest {
    fn new() -> Self { Self { trees: Vec::new() } }
    fn plant(&mut self, x: i32, y: i32, name: &str, color: &str, texture: &str) {
        self.trees.push((x, y, name.into(), color.into(), texture.into()));
    }
    fn draw(&self) {
        let mut factory = TreeFactory::new();
        for (x, y, name, color, texture) in &self.trees {
            let tt = factory.get_tree_type(name, color, texture);
            let tr = Tree { x: *x, y: *y, t: tt };
            tr.draw();
        }
    }
}

fn main() {
    let mut forest = Forest::new();
    for i in 0..5 { forest.plant(i, i*2, "Oak", "Green", "Rough"); }
    for i in 0..3 { forest.plant(i+10, i*3, "Pine", "DarkGreen", "Smooth"); }
    forest.draw();
}
