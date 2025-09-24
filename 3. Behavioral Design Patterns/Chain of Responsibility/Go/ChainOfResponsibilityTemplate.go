package main

// Chain of Responsibility Pattern – Go Template

type Handler interface {
	SetNext(Handler)
	HandleRequest(*Request)
}

type Request struct{ Data string }

type BaseHandler struct{ next Handler }
func (h *BaseHandler) SetNext(handler Handler) { h.next = handler }

type ConcreteHandlerA struct{ BaseHandler }
func (h *ConcreteHandlerA) HandleRequest(req *Request) {
	if h.canHandle(req) {
		h.processRequest(req)
	} else if h.next != nil {
		h.next.HandleRequest(req)
	}
}
func (h *ConcreteHandlerA) canHandle(req *Request) bool { return true /* condition */ }
func (h *ConcreteHandlerA) processRequest(req *Request) { /* handle */ }

type ConcreteHandlerB struct{ BaseHandler }
func (h *ConcreteHandlerB) HandleRequest(req *Request) {
	if h.canHandle(req) {
		h.processRequest(req)
	} else if h.next != nil {
		h.next.HandleRequest(req)
	}
}
func (h *ConcreteHandlerB) canHandle(req *Request) bool { return true /* condition */ }
func (h *ConcreteHandlerB) processRequest(req *Request) { /* handle */ }

func main() {
	handlerA := &ConcreteHandlerA{}
	handlerB := &ConcreteHandlerB{}
	handlerA.SetNext(handlerB)
	handlerA.HandleRequest(&Request{})
}
