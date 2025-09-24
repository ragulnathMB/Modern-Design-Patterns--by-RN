package main

import (
	"fmt"
	"math"
)

// Adapter Pattern Example in Go
// RoundHole fits RoundPeg. Adapt SquarePeg to IRoundPeg.

type RoundPeg interface{
	GetRadius() float64
}

type SimpleRoundPeg struct{ r float64 }
func (p SimpleRoundPeg) GetRadius() float64 { return p.r }

type RoundHole struct{ r float64 }
func (h RoundHole) Fits(p RoundPeg) bool { return p.GetRadius() <= h.r }

type SquarePeg struct{ w float64 }

type SquarePegAdapter struct{ peg SquarePeg }
func (a SquarePegAdapter) GetRadius() float64 { return (a.peg.w * math.Sqrt(2)) / 2 }

func main(){
	h := RoundHole{r:5}
	r := SimpleRoundPeg{r:5}
	fmt.Println(h.Fits(r))

	small := SquarePeg{w:7}
	large := SquarePeg{w:11}
	fmt.Println(h.Fits(SquarePegAdapter{peg: small}))
	fmt.Println(h.Fits(SquarePegAdapter{peg: large}))
}
