package main

import "fmt"

// Button is product A
type Button interface {
	Paint()
}

// Checkbox is product B
type Checkbox interface {
	Paint()
}

// WindowsButton is concrete product A1
type WindowsButton struct{}

func (WindowsButton) Paint() {
	fmt.Println("Render a button in Windows style.")
}

// MacButton is concrete product A2
type MacButton struct{}

func (MacButton) Paint() {
	fmt.Println("Render a button in macOS style.")
}

// WindowsCheckbox is concrete product B1
type WindowsCheckbox struct{}

func (WindowsCheckbox) Paint() {
	fmt.Println("Render a checkbox in Windows style.")
}

// MacCheckbox is concrete product B2
type MacCheckbox struct{}

func (MacCheckbox) Paint() {
	fmt.Println("Render a checkbox in macOS style.")
}

// GUIFactory is the abstract factory
type GUIFactory interface {
	CreateButton() Button
	CreateCheckbox() Checkbox
}

// WindowsFactory is concrete factory 1
type WindowsFactory struct{}

func (WindowsFactory) CreateButton() Button   { return WindowsButton{} }
func (WindowsFactory) CreateCheckbox() Checkbox { return WindowsCheckbox{} }

// MacFactory is concrete factory 2
type MacFactory struct{}

func (MacFactory) CreateButton() Button   { return MacButton{} }
func (MacFactory) CreateCheckbox() Checkbox { return MacCheckbox{} }

// Application is the client
type Application struct {
	button   Button
	checkbox Checkbox
}

func NewApplication(f GUIFactory) *Application {
	return &Application{button: f.CreateButton(), checkbox: f.CreateCheckbox()}
}

func (a Application) Paint() {
	a.button.Paint()
	a.checkbox.Paint()
}

func main() {
	var factory GUIFactory
	factory = WindowsFactory{}
	// Use MacFactory{} for macOS style
	app := NewApplication(factory)
	app.Paint()
}
