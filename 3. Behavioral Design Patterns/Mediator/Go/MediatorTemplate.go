package main

// Mediator Pattern – Go Template

type Mediator interface {
	Notify(sender interface{}, eventType string)
}

type Colleague interface {
	DoSomething()
}

type ConcreteColleagueA struct {
	mediator Mediator
}

func NewConcreteColleagueA(m Mediator) *ConcreteColleagueA {
	return &ConcreteColleagueA{mediator: m}
}

func (c *ConcreteColleagueA) DoSomething() {
	c.mediator.Notify(c, "EventA")
}

type ConcreteColleagueB struct {
	mediator Mediator
}

func NewConcreteColleagueB(m Mediator) *ConcreteColleagueB {
	return &ConcreteColleagueB{mediator: m}
}

func (c *ConcreteColleagueB) DoSomething() {
	c.mediator.Notify(c, "EventB")
}

type ConcreteMediator struct {
	colleagues []Colleague
}

func NewConcreteMediator() *ConcreteMediator {
	return &ConcreteMediator{colleagues: make([]Colleague, 0)}
}

func (m *ConcreteMediator) AddColleague(colleague Colleague) {
	m.colleagues = append(m.colleagues, colleague)
}

func (m *ConcreteMediator) Notify(sender interface{}, eventType string) {
	/* handle event */
}

func main() {
	mediator := NewConcreteMediator()
	colleagueA := NewConcreteColleagueA(mediator)
	colleagueB := NewConcreteColleagueB(mediator)
	mediator.AddColleague(colleagueA)
	mediator.AddColleague(colleagueB)
	colleagueA.DoSomething()
}
