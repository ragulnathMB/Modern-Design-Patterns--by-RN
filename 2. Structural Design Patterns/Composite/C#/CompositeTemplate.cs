// Composite Pattern – C# Template
// Component, Leaf, and Composite classes for tree structures.

using System.Collections.Generic;

namespace CompositeTemplate
{
    abstract class Component { public abstract void Operation(); }
    class Leaf : Component { public override void Operation() { /* ... */ } }
    class Composite : Component
    {
        private readonly List<Component> _children = new();
        public void Add(Component c) => _children.Add(c);
        public void Remove(Component c) => _children.Remove(c);
        public override void Operation() { foreach (var child in _children) child.Operation(); }
    }
    class Program { static void Main(){ var comp = new Composite(); comp.Add(new Leaf()); comp.Operation(); } }
}
