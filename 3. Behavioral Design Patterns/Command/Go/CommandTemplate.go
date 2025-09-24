package main

// Command Pattern – Go Template

type Command interface{ Execute(); Undo() }

type Receiver struct{}
func (Receiver) Action(){ /* do something */ }
func (Receiver) UndoAction(){ /* undo something */ }

type ConcreteCommand struct{ r Receiver }
func (c ConcreteCommand) Execute(){ c.r.Action() }
func (c ConcreteCommand) Undo(){ c.r.UndoAction() }

type Invoker struct{ cmd Command }
func (i *Invoker) Set(c Command){ i.cmd = c }
func (i Invoker) Run(){ if i.cmd != nil { i.cmd.Execute() } }
func (i Invoker) Undo(){ if i.cmd != nil { i.cmd.Undo() } }

func main(){ inv := Invoker{}; inv.Set(ConcreteCommand{Receiver{}}); inv.Run(); inv.Undo() }
