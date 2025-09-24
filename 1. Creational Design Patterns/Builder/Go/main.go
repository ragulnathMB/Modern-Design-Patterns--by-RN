package main

import "fmt"

// Product

type House struct {
	Walls string
	Roof  string
	Doors string
}

// Builder interface
type HouseBuilder interface {
	BuildWalls()
	BuildRoof()
	BuildDoors()
	GetResult() House
}

// Concrete Builder 1
type WoodenHouseBuilder struct{house House}
func (b *WoodenHouseBuilder) BuildWalls() { b.house.Walls = "Wooden Walls" }
func (b *WoodenHouseBuilder) BuildRoof() { b.house.Roof = "Wooden Roof" }
func (b *WoodenHouseBuilder) BuildDoors() { b.house.Doors = "Wooden Doors" }
func (b *WoodenHouseBuilder) GetResult() House { return b.house }

// Concrete Builder 2
type StoneHouseBuilder struct{house House}
func (b *StoneHouseBuilder) BuildWalls() { b.house.Walls = "Stone Walls" }
func (b *StoneHouseBuilder) BuildRoof() { b.house.Roof = "Stone Roof" }
func (b *StoneHouseBuilder) BuildDoors() { b.house.Doors = "Stone Doors" }
func (b *StoneHouseBuilder) GetResult() House { return b.house }

// Director

type Director struct{}
func (Director) Construct(b HouseBuilder) {
	b.BuildWalls()
	b.BuildRoof()
	b.BuildDoors()
}

func main() {
	var builder HouseBuilder
	builder = &WoodenHouseBuilder{}
	// switch to &StoneHouseBuilder{} for stone
	director := Director{}
	director.Construct(builder)
	fmt.Printf("%+v\n", builder.GetResult())
}
