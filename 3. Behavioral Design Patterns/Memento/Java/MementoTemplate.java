// Memento Pattern – Java Template

import java.util.*;

class Memento {
    private final String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}

class Originator {
    private String state;
    public void setState(String state) { this.state = state; }
    public String getState() { return state; }
    public Memento createMemento() { return new Memento(state); }
    public void restoreMemento(Memento memento) { state = memento.getState(); }
}

class Caretaker {
    private final Stack<Memento> mementos = new Stack<>();
    public void saveState(Originator originator) { mementos.push(originator.createMemento()); }
    public void restoreState(Originator originator) { if (!mementos.isEmpty()) originator.restoreMemento(mementos.pop()); }
}

public class MementoTemplate {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("State1");
        caretaker.saveState(originator);
        originator.setState("State2");
        caretaker.restoreState(originator);
    }
}
