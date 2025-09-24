// State Pattern – Java Template

interface State { void handle(Context context); }
class Context { private State state; Context(State s){ state = s; } void setState(State s){ state = s; } void request(){ state.handle(this); } }
class ConcreteStateA implements State { public void handle(Context c){ /* work */ c.setState(new ConcreteStateB()); } }
class ConcreteStateB implements State { public void handle(Context c){ /* work */ c.setState(new ConcreteStateA()); } }
public class StateTemplate { public static void main(String[] args){ Context c = new Context(new ConcreteStateA()); c.request(); c.request(); } }
