package main

// Observer Pattern – Go Template

type Observer interface{ Update() }
type Subject interface{ Attach(Observer); Detach(Observer); Notify() }

type ConcreteSubject struct{ observers []Observer }
func (s *ConcreteSubject) Attach(o Observer){ s.observers = append(s.observers, o) }
func (s *ConcreteSubject) Detach(o Observer){ for i, obs := range s.observers { if obs == o { s.observers = append(s.observers[:i], s.observers[i+1:]...); break } } }
func (s *ConcreteSubject) Notify(){ for _, o := range s.observers { o.Update() } }
func (s *ConcreteSubject) DoSomething(){ /* change state */ s.Notify() }

type ConcreteObserver struct{}
func (ConcreteObserver) Update(){ /* react to change */ }

func main(){ s := &ConcreteSubject{}; s.Attach(ConcreteObserver{}); s.DoSomething() }
