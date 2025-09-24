// Iterator Pattern – Rust Template

trait Iterator<T> {
    fn has_next(&self) -> bool;
    fn next(&mut self) -> Option<&T>;
}

trait Aggregate<T> {
    fn create_iterator(&self) -> ConcreteIterator<T>;
}

struct ConcreteIterator<'a, T> {
    items: &'a [T],
    index: usize,
}

impl<'a, T> ConcreteIterator<'a, T> {
    fn new(items: &'a [T]) -> Self {
        Self { items, index: 0 }
    }
}

impl<'a, T> Iterator<T> for ConcreteIterator<'a, T> {
    fn has_next(&self) -> bool {
        self.index < self.items.len()
    }

    fn next(&mut self) -> Option<&T> {
        if self.has_next() {
            let item = &self.items[self.index];
            self.index += 1;
            Some(item)
        } else {
            None
        }
    }
}

struct ConcreteAggregate<T> {
    items: Vec<T>,
}

impl<T> ConcreteAggregate<T> {
    fn new() -> Self {
        Self { items: Vec::new() }
    }

    fn add(&mut self, item: T) {
        self.items.push(item);
    }
}

impl<T> Aggregate<T> for ConcreteAggregate<T> {
    fn create_iterator(&self) -> ConcreteIterator<T> {
        ConcreteIterator::new(&self.items)
    }
}

fn main() {
    let mut aggregate = ConcreteAggregate::new();
    aggregate.add("Item1");
    aggregate.add("Item2");
    let mut iterator = aggregate.create_iterator();
    while iterator.has_next() {
        if let Some(_item) = iterator.next() {
            // use item
        }
    }
}
