package main

// Strategy Pattern – Go Template

type Strategy interface{ Execute([]int) []int }

type ConcreteStrategyA struct{}
func (ConcreteStrategyA) Execute(data []int) []int { return data }

type ConcreteStrategyB struct{}
func (ConcreteStrategyB) Execute(data []int) []int { return data }

type Context struct{ s Strategy }
func (c *Context) Set(s Strategy){ c.s = s }
func (c Context) Do(data []int) []int { return c.s.Execute(data) }

func main(){ ctx := Context{ s: ConcreteStrategyA{} }; _ = ctx.Do([]int{}) }
