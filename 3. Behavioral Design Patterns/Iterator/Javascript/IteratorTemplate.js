// Iterator Pattern – JavaScript Template

class Iterator { hasNext() {} next() {} }
class Aggregate { createIterator() {} }

class ConcreteIterator extends Iterator {
  constructor(items) { super(); this.items = items; this.index = 0 }
  hasNext() { return this.index < this.items.length }
  next() { return this.items[this.index++] }
}

class ConcreteAggregate extends Aggregate {
  constructor() { super(); this.items = [] }
  add(item) { this.items.push(item) }
  createIterator() { return new ConcreteIterator(this.items) }
}

;(function main() {
  const aggregate = new ConcreteAggregate()
  aggregate.add('Item1')
  aggregate.add('Item2')
  const iterator = aggregate.createIterator()
  while (iterator.hasNext()) { const item = iterator.next() }
})()
