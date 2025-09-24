# Strategy Pattern

The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## When to Use
- You have multiple ways to perform a task and want to swap them at runtime.
- You want to avoid large conditional statements (if/switch) selecting different behaviors.
- You want to isolate algorithm code behind a common interface.

## Example Overview
This example models a sorter that can use different sorting strategies.
- Context: `Sorter` holds a reference to a `SortStrategy` and delegates sorting to it.
- Strategy: `SortStrategy` interface with `sort(data)`.
- Concrete Strategies: `BubbleSort`, `QuickSort` (simple implementations for demonstration).

Typical flow:
1) Create a `Sorter` with `BubbleSort` Strategy and sort data.
2) Swap to `QuickSort` Strategy and sort again.

## Key Points
- Favor composition over inheritance: inject the strategy into the context.
- Strategies share a common interface; clients can provide any implementation.
- The context can expose a setter to change strategies at runtime.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
