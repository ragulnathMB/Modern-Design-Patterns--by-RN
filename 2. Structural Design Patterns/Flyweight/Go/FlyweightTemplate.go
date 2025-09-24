package main

// Flyweight Pattern – Go Template

type Flyweight struct{ /* intrinsic, immutable data */ }

type Factory struct{}
var fwCache = map[string]Flyweight{}

func (Factory) Get(key string) Flyweight {
	if fw, ok := fwCache[key]; ok { return fw }
	fw := Flyweight{}
	fwCache[key] = fw
	return fw
}

type Context struct{ fw Flyweight /* extrinsic fields here */ }

func NewContext(key string) Context { return Context{ fw: Factory{}.Get(key) } }
func (c Context) Operation(/* extrinsic params */) { /* use c.fw + extrinsic */ }

func main(){ c := NewContext("key"); c.Operation() }
