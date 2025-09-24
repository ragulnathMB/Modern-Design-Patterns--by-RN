// Prototype Pattern – JavaScript Template
class Prototype { clone(){} }
class ConcretePrototype extends Prototype { constructor(data){ super(); this.data=data; } clone(){ return new ConcretePrototype(this.data); } }
