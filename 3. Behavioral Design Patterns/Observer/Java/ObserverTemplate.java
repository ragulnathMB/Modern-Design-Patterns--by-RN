// Observer Pattern – Java Template

import java.util.*;

interface Observer { void update(); }
interface Subject { void attach(Observer o); void detach(Observer o); void notifyObservers(); }

class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    public void attach(Observer o){ observers.add(o); }
    public void detach(Observer o){ observers.remove(o); }
    public void notifyObservers(){ for (Observer o : observers) o.update(); }
    public void doSomething(){ /* change state */ notifyObservers(); }
}

class ConcreteObserver implements Observer { public void update(){ /* react to change */ } }

public class ObserverTemplate { public static void main(String[] args){ ConcreteSubject s = new ConcreteSubject(); s.attach(new ConcreteObserver()); s.doSomething(); } }
