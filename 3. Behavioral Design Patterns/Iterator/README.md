# Iterator Pattern

The Iterator pattern provides a way to access elements of a collection sequentially without exposing the underlying representation of the collection.

## When to Use
- You want to traverse a collection without exposing its internal structure.
- You want to support multiple traversal algorithms for the same collection.
- You want to provide a uniform interface for traversing different collection types.

## Example Overview
Example: a book collection that can be iterated through.
- Iterator: `Iterator<T>` interface with `hasNext()` and `next()` methods.
- Concrete Iterator: `BookIterator` implements traversal logic for books.
- Aggregate: `BookCollection` interface with `createIterator()`.
- Concrete Aggregate: `ConcreteBookCollection` stores books and creates iterators.

## Key Points
- Separates collection traversal from the collection itself.
- Multiple iterators can traverse the same collection simultaneously.
- Supports different traversal strategies (forward, backward, filtered, etc.).

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
