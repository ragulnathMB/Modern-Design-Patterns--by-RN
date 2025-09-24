package main

// Decorator Pattern – Go Template

type Component interface {
    Operation()
}

type ConcreteComponent struct{}
func (ConcreteComponent) Operation() { /* base work */ }

type BaseDecorator struct{ wrap Component }

func (d BaseDecorator) Operation() { d.wrap.Operation() }

type ConcreteDecoratorA struct{ BaseDecorator }

func (c ConcreteDecoratorA) Operation() { /* extra A */ c.BaseDecorator.Operation() }

type ConcreteDecoratorB struct{ BaseDecorator }

func (c ConcreteDecoratorB) Operation() { /* extra B */ c.BaseDecorator.Operation() }

func main() {
    var c Component = ConcreteDecoratorB{
        BaseDecorator{ConcreteDecoratorA{BaseDecorator{ConcreteComponent{}}}},
    }
    c.Operation()
}
