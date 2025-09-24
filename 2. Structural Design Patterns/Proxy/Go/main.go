package main

import "fmt"

// Proxy Pattern Example in Go
// Image viewer with lazy-loading proxy

type Image interface{ Display() }

type RealImage struct{ filename string }
func NewRealImage(filename string) *RealImage { ri := &RealImage{filename}; fmt.Println("Loading image:", filename); return ri }
func (r *RealImage) Display(){ fmt.Println("Displaying:", r.filename) }

type ProxyImage struct{ filename string; real *RealImage }
func (p *ProxyImage) Display(){ if p.real == nil { p.real = NewRealImage(p.filename) }; p.real.Display() }

func main(){ var img Image = &ProxyImage{filename: "photo.jpg"}; img.Display(); img.Display() }
