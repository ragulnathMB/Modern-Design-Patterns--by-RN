package main

// Builder Pattern – Go Template

type Product struct{}

type Builder interface {
	BuildPartA()
	BuildPartB()
	GetResult() Product
}

type ConcreteBuilder struct{product Product}

func (b *ConcreteBuilder) BuildPartA() {/*...*/}
func (b *ConcreteBuilder) BuildPartB() {/*...*/}
func (b *ConcreteBuilder) GetResult() Product { return b.product }

type Director struct{}
func (Director) Construct(b Builder) {
	b.BuildPartA()
	b.BuildPartB()
}

func main() {
	builder := &ConcreteBuilder{}
	Director{}.Construct(builder)
	_ = builder.GetResult()
}
