package main

// Adapter Pattern – Go Template
// Convert Adaptee to Target via Adapter.

type Target interface{ Request() }

type Adaptee struct{}
func (Adaptee) SpecificRequest() { /* ... */ }

type Adapter struct{ a Adaptee }
func (ad Adapter) Request(){ ad.a.SpecificRequest() }

func main(){ var t Target = Adapter{a: Adaptee{}}; t.Request() }
