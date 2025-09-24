// Mediator Pattern – TypeScript Template

interface Mediator { notify(sender: any, eventType: string): void }

abstract class Colleague {
  constructor(protected mediator: Mediator) {}
  abstract doSomething(): void
}

class ConcreteColleagueA extends Colleague {
  doSomething(): void { this.mediator.notify(this, 'EventA') }
}

class ConcreteColleagueB extends Colleague {
  doSomething(): void { this.mediator.notify(this, 'EventB') }
}

class ConcreteMediator implements Mediator {
  private colleagues: Colleague[] = []
  addColleague(colleague: Colleague): void { this.colleagues.push(colleague) }
  notify(sender: any, eventType: string): void { /* handle event */ }
}

;(function main() {
  const mediator = new ConcreteMediator()
  const colleagueA = new ConcreteColleagueA(mediator)
  const colleagueB = new ConcreteColleagueB(mediator)
  mediator.addColleague(colleagueA)
  mediator.addColleague(colleagueB)
  colleagueA.doSomething()
})()

export {}
