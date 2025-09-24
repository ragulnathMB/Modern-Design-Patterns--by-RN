// Facade Pattern – JavaScript Template

class SubsystemA { opA(){ /* ... */ } }
class SubsystemB { opB(){ /* ... */ } }
class SubsystemC { opC(){ /* ... */ } }

class Facade { constructor(){ this.a = new SubsystemA(); this.b = new SubsystemB(); this.c = new SubsystemC(); } doWork(){ this.a.opA(); this.b.opB(); this.c.opC(); } }

(function main(){ new Facade().doWork(); })();
