// Mediator Pattern – Java Template

import java.util.*;

interface Mediator { void notify(Object sender, String eventType); }

abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) { this.mediator = mediator; }
    public abstract void doSomething();
}

class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) { super(mediator); }
    public void doSomething() { mediator.notify(this, "EventA"); }
}

class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) { super(mediator); }
    public void doSomething() { mediator.notify(this, "EventB"); }
}

class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues = new ArrayList<>();
    public void addColleague(Colleague colleague) { colleagues.add(colleague); }
    public void notify(Object sender, String eventType) { /* handle event */ }
}

public class MediatorTemplate {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);
        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);
        colleagueA.doSomething();
    }
}
