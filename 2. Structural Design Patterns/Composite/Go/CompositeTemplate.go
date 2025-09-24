package main

// Composite Pattern – Go Template
// Component, Leaf, and Composite for tree structures.

import "fmt"

type Component interface {
	Operation()
}

type Leaf struct{}

func (Leaf) Operation() {
	// ... leaf behavior
}

type Composite struct{ children []Component }

func (c *Composite) Add(child Component)   { c.children = append(c.children, child) }
func (c *Composite) Remove(i int)          { c.children = append(c.children[:i], c.children[i+1:]...) }
func (c *Composite) Operation()            { for _, ch := range c.children { ch.Operation() } }

func main() {
	root := &Composite{}
	root.Add(Leaf{})
	root.Operation()
	fmt.Println("Composite template ran")
}
