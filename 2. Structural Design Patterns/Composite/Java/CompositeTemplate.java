// Composite Pattern – Java Template

import java.util.*;

abstract class Component { abstract void operation(); }
class Leaf extends Component { @Override void operation() { /* ... */ } }
class Composite extends Component {
    private final List<Component> children = new ArrayList<>();
    void add(Component c) { children.add(c); }
    void remove(Component c) { children.remove(c); }
    @Override void operation() { for (Component c : children) c.operation(); }
}
public class CompositeTemplate {
    public static void main(String[] args){ Composite root = new Composite(); root.add(new Leaf()); root.operation(); }
}
