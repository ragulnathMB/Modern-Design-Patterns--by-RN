# Visitor Pattern

The Visitor pattern lets you define new operations without changing the classes of the elements on which it operates. It separates algorithms from the object structure they operate on.

## When to Use
- You need to perform operations across a heterogeneous collection of objects.
- You want to add new operations without modifying existing element classes.
- The object structure is stable, but you frequently add new operations.

## Example Overview
Example: a document structure with different element types that can be processed by various visitors.
- Visitor: `DocumentVisitor` interface defines `visit(element)` methods for each element type.
- Concrete Visitors: `WordCountVisitor`, `PrintVisitor` implement specific operations.
- Element: `DocumentElement` interface with `accept(visitor)` method.
- Concrete Elements: `Paragraph`, `Image`, `Table` implement `accept()` and call appropriate visitor method.

## Key Points
- Elements accept visitors and call the appropriate visit method (double dispatch).
- Adding new operations is easy (new visitor), but adding new element types requires updating all visitors.
- Visitors can maintain state across visits to accumulate results.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
