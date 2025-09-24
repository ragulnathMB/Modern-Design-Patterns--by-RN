package main

import "fmt"

// Chain of Responsibility Pattern Example in Go
// Support ticket system with different levels of handlers

type SupportHandler interface {
	SetNext(SupportHandler)
	HandleRequest(*SupportTicket)
}

type SupportTicket struct {
	Issue    string
	Priority int
}

type BaseHandler struct {
	next SupportHandler
}

func (h *BaseHandler) SetNext(handler SupportHandler) {
	h.next = handler
}

type Level1Support struct {
	BaseHandler
}

func (h *Level1Support) HandleRequest(ticket *SupportTicket) {
	if ticket.Priority <= 1 {
		fmt.Printf("Level 1: Handled '%s'\n", ticket.Issue)
	} else if h.next != nil {
		h.next.HandleRequest(ticket)
	} else {
		fmt.Printf("No handler available for '%s'\n", ticket.Issue)
	}
}

type Level2Support struct {
	BaseHandler
}

func (h *Level2Support) HandleRequest(ticket *SupportTicket) {
	if ticket.Priority <= 2 {
		fmt.Printf("Level 2: Handled '%s'\n", ticket.Issue)
	} else if h.next != nil {
		h.next.HandleRequest(ticket)
	} else {
		fmt.Printf("No handler available for '%s'\n", ticket.Issue)
	}
}

type Level3Support struct {
	BaseHandler
}

func (h *Level3Support) HandleRequest(ticket *SupportTicket) {
	fmt.Printf("Level 3: Handled '%s'\n", ticket.Issue)
}

func main() {
	level1 := &Level1Support{}
	level2 := &Level2Support{}
	level3 := &Level3Support{}
	level1.SetNext(level2)
	level2.SetNext(level3)

	level1.HandleRequest(&SupportTicket{"Password reset", 1})
	level1.HandleRequest(&SupportTicket{"Software bug", 2})
	level1.HandleRequest(&SupportTicket{"System crash", 3})
}
