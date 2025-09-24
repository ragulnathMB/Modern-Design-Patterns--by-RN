// Chain of Responsibility Pattern – TypeScript Template

abstract class Handler {
  protected nextHandler: Handler | null = null
  setNext(handler: Handler): void { this.nextHandler = handler }
  abstract handleRequest(request: Request): void
}

class Request { constructor(public data: string = '') {} }

class ConcreteHandlerA extends Handler {
  handleRequest(request: Request): void {
    if (this.canHandle(request)) this.processRequest(request)
    else if (this.nextHandler) this.nextHandler.handleRequest(request)
  }
  private canHandle(request: Request): boolean { return true /* condition */ }
  private processRequest(request: Request): void { /* handle */ }
}

class ConcreteHandlerB extends Handler {
  handleRequest(request: Request): void {
    if (this.canHandle(request)) this.processRequest(request)
    else if (this.nextHandler) this.nextHandler.handleRequest(request)
  }
  private canHandle(request: Request): boolean { return true /* condition */ }
  private processRequest(request: Request): void { /* handle */ }
}

;(function main() {
  const handlerA = new ConcreteHandlerA()
  const handlerB = new ConcreteHandlerB()
  handlerA.setNext(handlerB)
  handlerA.handleRequest(new Request())
})()

export {}
