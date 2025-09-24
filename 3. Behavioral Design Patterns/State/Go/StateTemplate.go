package main

// State Pattern – Go Template

type State interface{ Handle(*Context) }

type Context struct{ state State }
func NewContext(s State) *Context { return &Context{state: s} }
func (c *Context) SetState(s State) { c.state = s }
func (c *Context) Request() { c.state.Handle(c) }

type ConcreteStateA struct{}
func (s *ConcreteStateA) Handle(c *Context) { /* work */ c.SetState(&ConcreteStateB{}) }

type ConcreteStateB struct{}
func (s *ConcreteStateB) Handle(c *Context) { /* work */ c.SetState(&ConcreteStateA{}) }

func main(){ ctx := NewContext(&ConcreteStateA{}); ctx.Request(); ctx.Request() }
