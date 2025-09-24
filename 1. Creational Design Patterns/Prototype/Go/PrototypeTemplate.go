package main

// Prototype Pattern – Go Template

type Prototype interface {
	Clone() Prototype
}

type ConcretePrototype struct{ Data int }
func (p *ConcretePrototype) Clone() Prototype { cp := *p; return &cp }

func main(){ original:=&ConcretePrototype{Data:42}; copy:=original.Clone(); _ = copy }
