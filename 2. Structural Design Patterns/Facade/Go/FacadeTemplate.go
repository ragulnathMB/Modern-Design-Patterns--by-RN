package main

// Facade Pattern – Go Template

type SubsystemA struct{}
func (SubsystemA) OpA(){ /* ... */ }

type SubsystemB struct{}
func (SubsystemB) OpB(){ /* ... */ }

type SubsystemC struct{}
func (SubsystemC) OpC(){ /* ... */ }

type Facade struct{ a SubsystemA; b SubsystemB; c SubsystemC }
func (f Facade) DoWork(){ f.a.OpA(); f.b.OpB(); f.c.OpC() }

func main(){ f := Facade{}; f.DoWork() }
