# Template Method Pattern

The Template Method pattern defines the skeleton of an algorithm in a base class, letting subclasses override specific steps without changing the algorithm's structure.

## When to Use
- You have multiple classes that implement similar algorithms with minor variations.
- You want to control which parts of an algorithm subclasses can customize.
- You want to avoid code duplication across similar algorithms.

## Example Overview
Example: a `DataProcessor` that follows the same steps (load, process, save) but with different implementations.
- Abstract Class: `DataProcessor` defines the template method `processData()` and abstract steps.
- Template Method: `processData()` calls `loadData()`, `processData()`, `saveData()` in sequence.
- Concrete Classes: `CSVProcessor`, `JSONProcessor` implement the abstract steps differently.

## Key Points
- Template method is final/non-virtual to preserve the algorithm structure.
- Abstract methods are customization points; concrete methods provide default behavior.
- Hook methods (empty or default implementations) provide optional extension points.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
