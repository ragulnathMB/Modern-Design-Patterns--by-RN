// Factory Method – Go Template
package main

type Product interface{}

type Creator interface{ FactoryMethod() Product }

type ConcreteCreator struct{}
func (ConcreteCreator) FactoryMethod() Product { return struct{}{} }

func main(){ var c Creator = ConcreteCreator{}; _ = c.FactoryMethod() }
