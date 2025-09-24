# Prototype Pattern

The Prototype pattern lets you create new objects by copying existing ones (prototypes) without coupling code to their concrete classes. Instead of constructing from scratch via `new`, clients call a `clone` operation.

## When to Use
- You need to create objects that are similar to an existing instance.
- Object creation is expensive or complex, and cloning is cheaper/simpler.
- You want to avoid binding code to concrete classes and prefer to copy via a common interface.

## Structure
```
Client → Prototype (clone)
           ↑
     ConcretePrototypeA
     ConcretePrototypeB
```


