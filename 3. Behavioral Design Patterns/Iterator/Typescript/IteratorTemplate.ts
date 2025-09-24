// Iterator Pattern – TypeScript Template

interface Iterator<T> { hasNext(): boolean; next(): T }
interface Aggregate<T> { createIterator(): Iterator<T> }

class ConcreteIterator<T> implements Iterator<T> {
  private index = 0
  constructor(private items: T[]) {}
  hasNext(): boolean { return this.index < this.items.length }
  next(): T { return this.items[this.index++] }
}

class ConcreteAggregate<T> implements Aggregate<T> {
  private items: T[] = []
  add(item: T): void { this.items.push(item) }
  createIterator(): Iterator<T> { return new ConcreteIterator(this.items) }
}

;(function main() {
  const aggregate = new ConcreteAggregate<string>()
  aggregate.add('Item1')
  aggregate.add('Item2')
  const iterator = aggregate.createIterator()
  while (iterator.hasNext()) { const item = iterator.next() }
})()

export {}
