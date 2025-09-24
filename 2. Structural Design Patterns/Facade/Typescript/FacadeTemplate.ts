// Facade Pattern – TypeScript Template

class SubsystemA { opA(){ /* ... */ } }
class SubsystemB { opB(){ /* ... */ } }
class SubsystemC { opC(){ /* ... */ } }

class Facade { private a = new SubsystemA(); private b = new SubsystemB(); private c = new SubsystemC(); doWork(){ this.a.opA(); this.b.opB(); this.c.opC(); } }

(function main(){ new Facade().doWork() })()

export {}
