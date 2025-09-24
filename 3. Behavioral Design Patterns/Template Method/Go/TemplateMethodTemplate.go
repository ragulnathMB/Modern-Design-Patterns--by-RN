package main

import "fmt"

// Template Method Pattern – Go Template

type AbstractClass interface {
	TemplateMethod()
	StepOne()
	StepTwo()
	Hook()
}

type BaseClass struct {
	impl AbstractClass
}

func (b *BaseClass) TemplateMethod() {
	b.impl.StepOne()
	b.impl.StepTwo()
	b.impl.Hook()
}

type ConcreteClassA struct {
	BaseClass
}

func NewConcreteClassA() *ConcreteClassA {
	c := &ConcreteClassA{}
	c.impl = c
	return c
}

func (c *ConcreteClassA) StepOne() { fmt.Println("A: Step 1") }
func (c *ConcreteClassA) StepTwo() { fmt.Println("A: Step 2") }
func (c *ConcreteClassA) Hook()    { /* optional */ }

type ConcreteClassB struct {
	BaseClass
}

func NewConcreteClassB() *ConcreteClassB {
	c := &ConcreteClassB{}
	c.impl = c
	return c
}

func (c *ConcreteClassB) StepOne() { fmt.Println("B: Step 1") }
func (c *ConcreteClassB) StepTwo() { fmt.Println("B: Step 2") }
func (c *ConcreteClassB) Hook()    { fmt.Println("B: Hook") }

func main() {
	NewConcreteClassA().TemplateMethod()
	NewConcreteClassB().TemplateMethod()
}
