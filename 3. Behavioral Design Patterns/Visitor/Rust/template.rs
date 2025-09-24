// Visitor Pattern – Rust Template

trait Visitor {
    fn visit_concrete_element_a(&mut self, element: &ConcreteElementA);
    fn visit_concrete_element_b(&mut self, element: &ConcreteElementB);
}

trait Element {
    fn accept(&self, visitor: &mut dyn Visitor);
}

struct ConcreteElementA;

impl ConcreteElementA {
    fn operation_a(&self) {
        // specific to A
    }
}

impl Element for ConcreteElementA {
    fn accept(&self, visitor: &mut dyn Visitor) {
        visitor.visit_concrete_element_a(self);
    }
}

struct ConcreteElementB;

impl ConcreteElementB {
    fn operation_b(&self) {
        // specific to B
    }
}

impl Element for ConcreteElementB {
    fn accept(&self, visitor: &mut dyn Visitor) {
        visitor.visit_concrete_element_b(self);
    }
}

struct ConcreteVisitor1;

impl Visitor for ConcreteVisitor1 {
    fn visit_concrete_element_a(&mut self, element: &ConcreteElementA) {
        element.operation_a();
        // visitor 1 logic
    }

    fn visit_concrete_element_b(&mut self, element: &ConcreteElementB) {
        element.operation_b();
        // visitor 1 logic
    }
}

struct ConcreteVisitor2;

impl Visitor for ConcreteVisitor2 {
    fn visit_concrete_element_a(&mut self, element: &ConcreteElementA) {
        element.operation_a();
        // visitor 2 logic
    }

    fn visit_concrete_element_b(&mut self, element: &ConcreteElementB) {
        element.operation_b();
        // visitor 2 logic
    }
}

fn main() {
    let elements: Vec<Box<dyn Element>> = vec![
        Box::new(ConcreteElementA),
        Box::new(ConcreteElementB),
    ];
    let mut visitor = ConcreteVisitor1;
    for element in &elements {
        element.accept(&mut visitor);
    }
}
