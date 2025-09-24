package main

// Visitor Pattern – Go Template

type Visitor interface {
	VisitConcreteElementA(*ConcreteElementA)
	VisitConcreteElementB(*ConcreteElementB)
}

type Element interface {
	Accept(Visitor)
}

type ConcreteElementA struct{}

func (a *ConcreteElementA) Accept(visitor Visitor) {
	visitor.VisitConcreteElementA(a)
}

func (a *ConcreteElementA) OperationA() {
	// specific to A
}

type ConcreteElementB struct{}

func (b *ConcreteElementB) Accept(visitor Visitor) {
	visitor.VisitConcreteElementB(b)
}

func (b *ConcreteElementB) OperationB() {
	// specific to B
}

type ConcreteVisitor1 struct{}

func (v *ConcreteVisitor1) VisitConcreteElementA(element *ConcreteElementA) {
	element.OperationA()
	// visitor 1 logic
}

func (v *ConcreteVisitor1) VisitConcreteElementB(element *ConcreteElementB) {
	element.OperationB()
	// visitor 1 logic
}

type ConcreteVisitor2 struct{}

func (v *ConcreteVisitor2) VisitConcreteElementA(element *ConcreteElementA) {
	element.OperationA()
	// visitor 2 logic
}

func (v *ConcreteVisitor2) VisitConcreteElementB(element *ConcreteElementB) {
	element.OperationB()
	// visitor 2 logic
}

func main() {
	elements := []Element{&ConcreteElementA{}, &ConcreteElementB{}}
	visitor := &ConcreteVisitor1{}
	for _, element := range elements {
		element.Accept(visitor)
	}
}
