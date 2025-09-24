package main

// Bridge Pattern – Go Template
// Separate Abstraction from Implementor so they can vary independently.

type Implementor interface{ OpImpl() }

type ConcreteImplA struct{}
func (ConcreteImplA) OpImpl() { /* ... */ }

type Abstraction struct{ impl Implementor }
func (a Abstraction) Operation(){ a.impl.OpImpl() }

type RefinedAbstraction struct{ Abstraction }

func main(){ a := RefinedAbstraction{Abstraction{impl: ConcreteImplA{}}}; a.Operation() }
