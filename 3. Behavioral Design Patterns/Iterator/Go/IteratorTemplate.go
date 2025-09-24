package main

// Iterator Pattern – Go Template

type Iterator interface {
	HasNext() bool
	Next() interface{}
}

type Aggregate interface {
	CreateIterator() Iterator
}

type ConcreteIterator struct {
	items []interface{}
	index int
}

func NewConcreteIterator(items []interface{}) *ConcreteIterator {
	return &ConcreteIterator{items: items, index: 0}
}

func (ci *ConcreteIterator) HasNext() bool {
	return ci.index < len(ci.items)
}

func (ci *ConcreteIterator) Next() interface{} {
	if ci.HasNext() {
		item := ci.items[ci.index]
		ci.index++
		return item
	}
	return nil
}

type ConcreteAggregate struct {
	items []interface{}
}

func NewConcreteAggregate() *ConcreteAggregate {
	return &ConcreteAggregate{items: make([]interface{}, 0)}
}

func (ca *ConcreteAggregate) Add(item interface{}) {
	ca.items = append(ca.items, item)
}

func (ca *ConcreteAggregate) CreateIterator() Iterator {
	return NewConcreteIterator(ca.items)
}

func main() {
	aggregate := NewConcreteAggregate()
	aggregate.Add("Item1")
	aggregate.Add("Item2")
	iterator := aggregate.CreateIterator()
	for iterator.HasNext() {
		item := iterator.Next()
		_ = item
	}
}
