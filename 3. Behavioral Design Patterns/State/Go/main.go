package main

import "fmt"

// State Pattern Example in Go
// TrafficLight cycles through Red, Yellow, Green states

type TrafficLightState interface{ Next(*TrafficLight); GetColor() string }

type TrafficLight struct{ state TrafficLightState }
func NewTrafficLight() *TrafficLight { return &TrafficLight{state: &RedState{}} }
func (t *TrafficLight) SetState(s TrafficLightState) { t.state = s }
func (t *TrafficLight) Next() { t.state.Next(t) }
func (t *TrafficLight) GetColor() string { return t.state.GetColor() }

type RedState struct{}
func (r *RedState) Next(t *TrafficLight) { t.SetState(&GreenState{}) }
func (r *RedState) GetColor() string { return "Red" }

type YellowState struct{}
func (y *YellowState) Next(t *TrafficLight) { t.SetState(&RedState{}) }
func (y *YellowState) GetColor() string { return "Yellow" }

type GreenState struct{}
func (g *GreenState) Next(t *TrafficLight) { t.SetState(&YellowState{}) }
func (g *GreenState) GetColor() string { return "Green" }

func main(){
	light := NewTrafficLight()
	for i := 0; i < 6; i++ {
		fmt.Printf("Light: %s\n", light.GetColor())
		light.Next()
	}
}
