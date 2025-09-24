// Mediator Pattern – JavaScript Template

class Mediator { notify(sender, eventType) {} }

class Colleague {
  constructor(mediator) { this.mediator = mediator }
  doSomething() {}
}

class ConcreteColleagueA extends Colleague {
  doSomething() { this.mediator.notify(this, 'EventA') }
}

class ConcreteColleagueB extends Colleague {
  doSomething() { this.mediator.notify(this, 'EventB') }
}

class ConcreteMediator extends Mediator {
  constructor() { super(); this.colleagues = [] }
  addColleague(colleague) { this.colleagues.push(colleague) }
  notify(sender, eventType) { /* handle event */ }
}

;(function main() {
  const mediator = new ConcreteMediator()
  const colleagueA = new ConcreteColleagueA(mediator)
  const colleagueB = new ConcreteColleagueB(mediator)
  mediator.addColleague(colleagueA)
  mediator.addColleague(colleagueB)
  colleagueA.doSomething()
})()
