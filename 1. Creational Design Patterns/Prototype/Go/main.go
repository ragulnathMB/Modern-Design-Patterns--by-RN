package main

import "fmt"

// Prototype interface

type Shape interface {
	Clone() Shape
	Draw()
}

type Rectangle struct {
	x, y          int
	width, height int
	color         string
}

func (r *Rectangle) Clone() Shape {
	clone := *r
	return &clone
}
func (r *Rectangle) Draw() {
	fmt.Printf("Rectangle at (%d,%d) size(%d,%d) color=%s\n", r.x, r.y, r.width, r.height, r.color)
}

type Circle struct {
	x, y  int
	radius int
	color  string
}
func (c *Circle) Clone() Shape { clone := *c; return &clone }
func (c *Circle) Draw() { fmt.Printf("Circle at (%d,%d) r=%d color=%s\n", c.x, c.y, c.radius, c.color) }

func main() {
	rect1 := &Rectangle{x: 10, y: 20, width: 30, height: 40, color: "red"}
	rect2 := rect1.Clone().(*Rectangle)
	rect2.x += 100
	rect1.Draw()
	rect2.Draw()
}
