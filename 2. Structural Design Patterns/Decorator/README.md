 # Decorator Pattern

 The Decorator pattern lets you attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

 ## When to Use
 - You need to add behavior to individual objects at runtime, without affecting other objects of the same class.
 - You want to compose several behaviors in different combinations (stack multiple decorators).
 - Subclassing would create a large number of classes for every combination of behaviors.

 ## Example Overview
 Example models a notification system.
 - Component: `Notifier` interface with `send(message)`.
 - Concrete Component: `BasicNotifier` sends a base notification (e.g., console/log).
 - Decorators: `EmailDecorator`, `SMSDecorator`, `SlackDecorator` add channels and delegate to the wrapped notifier.

 Typical flow:
 1) Create a `BasicNotifier`.
 2) Wrap it with `EmailDecorator`, then `SMSDecorator`, then `SlackDecorator`.
 3) Call `send("...message...")` on the outermost decorator; each decorator adds its work and forwards the call.

 ## Key Points
 - Decorators implement the same interface as the component and keep a reference to a wrapped component.
 - You can stack decorators in any order to combine behaviors.
 - Prefer a simple, minimal component interface to keep decorators easy to implement.

 The repository includes example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.

