package main

import "fmt"

// Decorator Pattern Example in Go
// Notifier: Basic + Email + SMS + Slack decorators

type Notifier interface{ Send(msg string) }

type BasicNotifier struct{}
func (BasicNotifier) Send(msg string){ fmt.Println("Base notify:", msg) }

type Decorator struct{ wrap Notifier }
func (d Decorator) Send(msg string){ d.wrap.Send(msg) }

type EmailDecorator struct{ Decorator }
func (e EmailDecorator) Send(msg string){ fmt.Println("Email sent:", msg); e.Decorator.Send(msg) }

type SMSDecorator struct{ Decorator }
func (s SMSDecorator) Send(msg string){ fmt.Println("SMS sent:", msg); s.Decorator.Send(msg) }

type SlackDecorator struct{ Decorator }
func (s SlackDecorator) Send(msg string){ fmt.Println("Slack message sent:", msg); s.Decorator.Send(msg) }

func main(){
	var n Notifier = BasicNotifier{}
	n = EmailDecorator{Decorator{n}}
	n = SMSDecorator{Decorator{n}}
	n = SlackDecorator{Decorator{n}}
	n.Send("System maintenance at 2 AM")
}
