package main

import (
    "fmt"
    "os"
)

// Product

type Transport interface {
    Deliver()
}

type Truck struct{}

func (Truck) Deliver() {
    fmt.Println("Deliver by land in a box.")
}

type Ship struct{}

func (Ship) Deliver() {
    fmt.Println("Deliver by sea in a container.")
}

// Creator

type Logistics interface {
    PlanDelivery()
}

type baseLogistics struct{}

func (baseLogistics) PlanDelivery() {}

// Concrete Creators

type RoadLogistics struct{}

func (RoadLogistics) PlanDelivery() { Truck{}.Deliver() }

type SeaLogistics struct{}

func (SeaLogistics) PlanDelivery() { Ship{}.Deliver() }

func main() {
    // Optional arg: "sea" to use Ship; any other value (or none) uses Truck
    var l Logistics
    if len(os.Args) > 1 && os.Args[1] == "sea" {
        l = SeaLogistics{}
    } else {
        l = RoadLogistics{}
    }
    l.PlanDelivery()
}
