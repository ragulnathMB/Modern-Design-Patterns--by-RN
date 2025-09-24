// Facade Pattern – Java Template

class SubsystemA { void opA(){ /* ... */ } }
class SubsystemB { void opB(){ /* ... */ } }
class SubsystemC { void opC(){ /* ... */ } }

class Facade { private final SubsystemA a = new SubsystemA(); private final SubsystemB b = new SubsystemB(); private final SubsystemC c = new SubsystemC(); void doWork(){ a.opA(); b.opB(); c.opC(); } }

public class FacadeTemplate { public static void main(String[] args){ new Facade().doWork(); } }
