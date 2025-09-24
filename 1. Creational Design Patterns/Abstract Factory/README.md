# Abstract Factory Pattern

The **Abstract Factory** pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.
It is useful when your code needs to work with various families of products but you don’t want it to depend on the concrete classes of those products.

## UML
```
Client → AbstractFactory → {ProductA, ProductB}
                    ↘ ConcreteFactory1 → {ConcreteProductA1, ConcreteProductB1}
                    ↘ ConcreteFactory2 → {ConcreteProductA2, ConcreteProductB2}
```

## When to Use
1. Your system needs to be independent of how its products are created.
2. You need to ensure that products from one family are used together.
3. You want to provide a library of products and reveal only their interfaces, not implementations.
