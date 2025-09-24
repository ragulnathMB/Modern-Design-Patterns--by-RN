// Chain of Responsibility Pattern – JavaScript Template

class Handler {
  constructor() { this.nextHandler = null }
  setNext(handler) { this.nextHandler = handler }
  handleRequest(request) { throw new Error('Abstract method') }
}

class Request { constructor(data = '') { this.data = data } }

class ConcreteHandlerA extends Handler {
  handleRequest(request) {
    if (this.canHandle(request)) this.processRequest(request)
    else if (this.nextHandler) this.nextHandler.handleRequest(request)
  }
  canHandle(request) { return true /* condition */ }
  processRequest(request) { /* handle */ }
}

class ConcreteHandlerB extends Handler {
  handleRequest(request) {
    if (this.canHandle(request)) this.processRequest(request)
    else if (this.nextHandler) this.nextHandler.handleRequest(request)
  }
  canHandle(request) { return true /* condition */ }
  processRequest(request) { /* handle */ }
}

;(function main() {
  const handlerA = new ConcreteHandlerA()
  const handlerB = new ConcreteHandlerB()
  handlerA.setNext(handlerB)
  handlerA.handleRequest(new Request())
})()
