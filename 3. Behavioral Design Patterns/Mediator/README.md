# Mediator Pattern

The Mediator pattern defines how a set of objects interact with each other. Instead of objects communicating directly, they communicate through a central mediator object, promoting loose coupling.

## When to Use
- You have a set of objects that communicate in complex ways.
- You want to avoid tight coupling between communicating objects.
- You want to reuse objects independently of their communication logic.

## Example Overview
Example: a chat room where users send messages through a mediator.
- Mediator: `ChatRoom` interface defines `sendMessage(message, user)`.
- Concrete Mediator: `ConcreteChatRoom` manages users and routes messages.
- Colleague: `User` abstract class with `send(message)` and `receive(message)`.
- Concrete Colleagues: `ConcreteUser` implementations that send/receive through mediator.

## Key Points
- Colleagues don't reference each other directly; they only know the mediator.
- The mediator encapsulates the interaction logic between colleagues.
- Adding new colleagues or changing interactions only requires mediator changes.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
