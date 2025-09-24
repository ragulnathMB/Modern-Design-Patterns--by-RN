package main

// Memento Pattern – Go Template

type Memento struct {
	state string
}

func NewMemento(state string) *Memento {
	return &Memento{state: state}
}

func (m *Memento) GetState() string {
	return m.state
}

type Originator struct {
	state string
}

func NewOriginator() *Originator {
	return &Originator{}
}

func (o *Originator) SetState(state string) {
	o.state = state
}

func (o *Originator) GetState() string {
	return o.state
}

func (o *Originator) CreateMemento() *Memento {
	return NewMemento(o.state)
}

func (o *Originator) RestoreMemento(memento *Memento) {
	o.state = memento.GetState()
}

type Caretaker struct {
	mementos []*Memento
}

func NewCaretaker() *Caretaker {
	return &Caretaker{mementos: make([]*Memento, 0)}
}

func (c *Caretaker) SaveState(originator *Originator) {
	c.mementos = append(c.mementos, originator.CreateMemento())
}

func (c *Caretaker) RestoreState(originator *Originator) {
	if len(c.mementos) > 0 {
		memento := c.mementos[len(c.mementos)-1]
		c.mementos = c.mementos[:len(c.mementos)-1]
		originator.RestoreMemento(memento)
	}
}

func main() {
	originator := NewOriginator()
	caretaker := NewCaretaker()
	originator.SetState("State1")
	caretaker.SaveState(originator)
	originator.SetState("State2")
	caretaker.RestoreState(originator)
}
