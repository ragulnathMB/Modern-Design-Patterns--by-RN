package main

import "fmt"

// Observer Pattern Example in Go
// WeatherStation notifies Display observers when temperature changes

type Observer interface{ Update(float32) }

type Subject interface{ Attach(Observer); Detach(Observer); Notify() }

type WeatherStation struct{ observers []Observer; temperature float32 }
func (w *WeatherStation) Attach(o Observer){ w.observers = append(w.observers, o) }
func (w *WeatherStation) Detach(o Observer){ for i, obs := range w.observers { if obs == o { w.observers = append(w.observers[:i], w.observers[i+1:]...); break } } }
func (w *WeatherStation) Notify(){ for _, o := range w.observers { o.Update(w.temperature) } }
func (w *WeatherStation) SetTemperature(temp float32){ w.temperature = temp; w.Notify() }

type PhoneDisplay struct{}
func (PhoneDisplay) Update(temp float32){ fmt.Printf("Phone: Temperature is %.1f°C\n", temp) }

type WindowDisplay struct{}
func (WindowDisplay) Update(temp float32){ fmt.Printf("Window: Temperature is %.1f°C\n", temp) }

func main(){
	station := &WeatherStation{}
	phone := PhoneDisplay{}
	window := WindowDisplay{}
	station.Attach(phone)
	station.Attach(window)
	station.SetTemperature(25.5)
	station.SetTemperature(30.2)
}
