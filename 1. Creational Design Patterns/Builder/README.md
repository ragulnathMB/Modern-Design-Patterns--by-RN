# Builder Pattern

The **Builder** pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## UML
```
Director → Builder ← ConcreteBuilder
                    ↓
                 Product
```

## When to Use
1. You need to construct complex objects step by step.
2. You want to reuse the same construction code for creating different representations.

