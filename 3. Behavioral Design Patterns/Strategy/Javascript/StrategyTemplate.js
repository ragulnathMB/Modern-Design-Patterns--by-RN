// Strategy Pattern – JavaScript Template

class Strategy { execute(data){ return data } }
class ConcreteStrategyA extends Strategy { execute(data){ return data } }
class ConcreteStrategyB extends Strategy { execute(data){ return data } }

class Context {
  constructor(strategy){ this.strategy = strategy }
  setStrategy(strategy){ this.strategy = strategy }
  doWork(data){ return this.strategy.execute(data) }
}

;(function main(){ const ctx = new Context(new ConcreteStrategyA()); ctx.doWork([]) })()
