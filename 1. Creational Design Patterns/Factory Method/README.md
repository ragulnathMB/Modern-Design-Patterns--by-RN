# Factory Method Pattern

The **Factory Method** pattern defines an interface for creating an object but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## UML
```
Creator → factoryMethod() → Product
  ↑                         ↑
ConcreteCreator      ConcreteProduct
```

## When to Use
1. You don’t know ahead of time what exact types of objects you will need.
2. You want subclasses to specify the objects to be created.

## Running the Demos
Same command style as other patterns—compile/run the `FactoryMethodExample` file inside the desired language folder. Example for Go:
```
cd Go
go run main.go sea   # "sea" argument picks Ship
```
