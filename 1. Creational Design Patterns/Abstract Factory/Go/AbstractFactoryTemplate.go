// Abstract Factory Pattern – Go Skeleton / Template
// Replace products & factories according to your domain logic.
package main

// TODO: Define abstract products

type ProductA interface{}
type ProductB interface{}

// TODO: Define concrete products

type ConcreteProductA1 struct{}
type ConcreteProductB1 struct{}

// TODO: Define abstract factory

type AbstractFactory interface {
	CreateProductA() ProductA
	CreateProductB() ProductB
}

// TODO: Implement concrete factory

type ConcreteFactory1 struct{}

func (ConcreteFactory1) CreateProductA() ProductA { return ConcreteProductA1{} }
func (ConcreteFactory1) CreateProductB() ProductB { return ConcreteProductB1{} }

func main() {
	// TODO: Client code
}
