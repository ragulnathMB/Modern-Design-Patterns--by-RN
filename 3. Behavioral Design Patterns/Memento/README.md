# Memento Pattern

The Memento pattern captures and externalizes an object's internal state so that the object can be restored to this state later, without violating encapsulation.

## When to Use
- You need to save and restore an object's state (undo/redo functionality).
- You want to provide a snapshot of an object's state without exposing its internal structure.
- Direct access to the object's fields would violate encapsulation.

## Example Overview
Example: a text editor that can save and restore document states.
- Originator: `TextEditor` creates and restores from mementos.
- Memento: `TextMemento` stores the editor's state (text content).
- Caretaker: `EditorHistory` manages memento storage and retrieval.

## Key Points
- Only the originator can create and read mementos; caretakers store them opaquely.
- Mementos should be immutable to prevent external modification.
- Consider memory usage when storing many mementos.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
