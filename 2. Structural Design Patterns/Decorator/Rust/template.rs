// Decorator Pattern – Rust Template

trait Component {
    fn operation(&self);
}

struct ConcreteComponent;

impl Component for ConcreteComponent {
    fn operation(&self) {
        /* base work */
    }
}

struct Decorator<T: Component> {
    inner: T,
}

impl<T: Component> Component for Decorator<T> {
    fn operation(&self) {
        self.inner.operation();
    }
}

struct ConcreteDecoratorA<T: Component> {
    inner: T,
}

impl<T: Component> Component for ConcreteDecoratorA<T> {
    fn operation(&self) {
        /* extra A */
        self.inner.operation();
    }
}

struct ConcreteDecoratorB<T: Component> {
    inner: T,
}

impl<T: Component> Component for ConcreteDecoratorB<T> {
    fn operation(&self) {
        /* extra B */
        self.inner.operation();
    }
}

fn main() {
    let c = ConcreteDecoratorB {
        inner: ConcreteDecoratorA {
            inner: ConcreteComponent,
        },
    };
    c.operation();
}
