package main

import "fmt"

// Mediator Pattern Example in Go
// Chat room where users send messages through a mediator

type ChatRoom interface {
	SendMessage(message string, user User)
	AddUser(user User)
}

type User interface {
	Send(message string)
	Receive(message, from string)
	GetName() string
}

type ConcreteUser struct {
	name     string
	chatRoom ChatRoom
}

func NewConcreteUser(name string, room ChatRoom) *ConcreteUser {
	return &ConcreteUser{name: name, chatRoom: room}
}

func (u *ConcreteUser) Send(message string) {
	u.chatRoom.SendMessage(message, u)
}

func (u *ConcreteUser) Receive(message, from string) {
	fmt.Printf("%s received: %s (from %s)\n", u.name, message, from)
}

func (u *ConcreteUser) GetName() string {
	return u.name
}

type ConcreteChatRoom struct {
	users []User
}

func NewConcreteChatRoom() *ConcreteChatRoom {
	return &ConcreteChatRoom{users: make([]User, 0)}
}

func (c *ConcreteChatRoom) AddUser(user User) {
	c.users = append(c.users, user)
}

func (c *ConcreteChatRoom) SendMessage(message string, sender User) {
	for _, user := range c.users {
		if user != sender {
			user.Receive(message, sender.GetName())
		}
	}
}

func main() {
	chatRoom := NewConcreteChatRoom()
	alice := NewConcreteUser("Alice", chatRoom)
	bob := NewConcreteUser("Bob", chatRoom)
	charlie := NewConcreteUser("Charlie", chatRoom)
	chatRoom.AddUser(alice)
	chatRoom.AddUser(bob)
	chatRoom.AddUser(charlie)

	alice.Send("Hello everyone!")
	bob.Send("Hi Alice!")
}
