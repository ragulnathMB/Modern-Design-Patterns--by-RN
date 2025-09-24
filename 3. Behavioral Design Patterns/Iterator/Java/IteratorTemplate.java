// Iterator Pattern – Java Template

import java.util.*;

interface Iterator<T> { boolean hasNext(); T next(); }
interface Aggregate<T> { Iterator<T> createIterator(); }

class ConcreteIterator<T> implements Iterator<T> {
    private final List<T> items;
    private int index = 0;
    public ConcreteIterator(List<T> items) { this.items = items; }
    public boolean hasNext() { return index < items.size(); }
    public T next() { return items.get(index++); }
}

class ConcreteAggregate<T> implements Aggregate<T> {
    private final List<T> items = new ArrayList<>();
    public void add(T item) { items.add(item); }
    public Iterator<T> createIterator() { return new ConcreteIterator<>(items); }
}

public class IteratorTemplate {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("Item1");
        aggregate.add("Item2");
        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) { String item = iterator.next(); }
    }
}
