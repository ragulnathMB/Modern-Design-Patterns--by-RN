// Bridge Pattern – Java Template
// Separate Abstraction from Implementor so they can vary independently.

interface Implementor { void opImpl(); }
class ConcreteImplementorA implements Implementor { public void opImpl(){ /* ... */ } }

class Abstraction {
    protected final Implementor impl;
    Abstraction(Implementor impl){ this.impl = impl; }
    void operation(){ impl.opImpl(); }
}

class RefinedAbstraction extends Abstraction {
    RefinedAbstraction(Implementor impl){ super(impl); }
    @Override void operation(){ super.operation(); }
}

public class BridgeTemplate { public static void main(String[] args){ new RefinedAbstraction(new ConcreteImplementorA()).operation(); } }
