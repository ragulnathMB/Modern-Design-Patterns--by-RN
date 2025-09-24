// Prototype Pattern – Rust Example
 
#[derive(Clone)]
struct Rectangle {
    x: i32,
    y: i32,
    width: i32,
    height: i32,
    color: String,
}

#[derive(Clone)]
struct Circle {
    x: i32,
    y: i32,
    radius: i32,
    color: String,
}

// Trait-object friendly clone pattern
trait Shape: ShapeClone {
    fn draw(&self);
}

trait ShapeClone {
    fn clone_box(&self) -> Box<dyn Shape>;
}

impl<T> ShapeClone for T
where
    T: 'static + Shape + Clone,
{
    fn clone_box(&self) -> Box<dyn Shape> {
        Box::new(self.clone())
    }
}

impl Clone for Box<dyn Shape> {
    fn clone(&self) -> Box<dyn Shape> {
        self.clone_box()
    }
}

impl Shape for Rectangle {
    fn draw(&self) {
        println!(
            "Rectangle: {},{} {}x{} color={}",
            self.x, self.y, self.width, self.height, self.color
        );
    }
}

impl Shape for Circle {
    fn draw(&self) {
        println!(
            "Circle: {},{} r={} color={}",
            self.x, self.y, self.radius, self.color
        );
    }
}

fn main() {
    let rect1 = Rectangle {
        x: 10,
        y: 20,
        width: 30,
        height: 40,
        color: "red".into(),
    };

    // Clone as a concrete type
    let mut rect2 = rect1.clone();
    rect2.x += 100;

    // Use as trait objects
    let s1: Box<dyn Shape> = Box::new(rect1);
    let s2: Box<dyn Shape> = s1.clone();

    s2.draw();
}
