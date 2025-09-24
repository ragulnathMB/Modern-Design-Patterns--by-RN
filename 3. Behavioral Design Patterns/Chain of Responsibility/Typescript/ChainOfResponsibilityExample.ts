// Chain of Responsibility Pattern Example in TypeScript
// Support ticket system with different levels of handlers

abstract class SupportHandler {
  protected nextHandler: SupportHandler | null = null
  setNext(handler: SupportHandler): void { this.nextHandler = handler }
  abstract handleRequest(ticket: SupportTicket): void
}

class SupportTicket {
  constructor(public issue: string, public priority: number) {}
}

class Level1Support extends SupportHandler {
  handleRequest(ticket: SupportTicket): void {
    if (ticket.priority <= 1)
      console.log(`Level 1: Handled '${ticket.issue}'`)
    else if (this.nextHandler)
      this.nextHandler.handleRequest(ticket)
    else
      console.log(`No handler available for '${ticket.issue}'`)
  }
}

class Level2Support extends SupportHandler {
  handleRequest(ticket: SupportTicket): void {
    if (ticket.priority <= 2)
      console.log(`Level 2: Handled '${ticket.issue}'`)
    else if (this.nextHandler)
      this.nextHandler.handleRequest(ticket)
    else
      console.log(`No handler available for '${ticket.issue}'`)
  }
}

class Level3Support extends SupportHandler {
  handleRequest(ticket: SupportTicket): void {
    console.log(`Level 3: Handled '${ticket.issue}'`)
  }
}

;(function main() {
  const level1 = new Level1Support()
  const level2 = new Level2Support()
  const level3 = new Level3Support()
  level1.setNext(level2)
  level2.setNext(level3)

  level1.handleRequest(new SupportTicket('Password reset', 1))
  level1.handleRequest(new SupportTicket('Software bug', 2))
  level1.handleRequest(new SupportTicket('System crash', 3))
})()

export {}
