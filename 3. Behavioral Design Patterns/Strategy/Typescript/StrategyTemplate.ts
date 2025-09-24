// Strategy Pattern – TypeScript Template

interface Strategy { execute(data: number[]): number[] }
class ConcreteStrategyA implements Strategy { execute(data: number[]): number[] { return data } }
class ConcreteStrategyB implements Strategy { execute(data: number[]): number[] { return [...data].reverse() } }

class Context {
  constructor(private strategy: Strategy) {}
  setStrategy(s: Strategy){ this.strategy = s }
  doWork(data: number[]): number[] { return this.strategy.execute(data) }
}

;(function main(){ const ctx = new Context(new ConcreteStrategyA()); ctx.doWork([]) })()

export {}
