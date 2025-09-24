# Observer Pattern

The Observer pattern defines a one‑to‑many dependency between objects so that when one object (the Subject) changes state, all its dependents (Observers) are notified and updated automatically.

## When to Use
- You need to notify multiple interested parties about changes in a subject’s state.
- You want to decouple the subject from concrete observers.
- You want to allow observers to subscribe/unsubscribe at runtime.

## Example Overview
Example: a `WeatherStation` (Subject) notifies multiple `Display` observers when temperature changes.
- Subject: `Subject` or `WeatherStation` manages observers and state.
- Observer: `Observer` interface defines `update(...)` method.
- Concrete Observers: `PhoneDisplay`, `WindowDisplay` implement update and render.

## Key Points
- Observers pull or get pushed new state. Keeping updates minimal reduces coupling.
- Allow dynamic subscription/unsubscription to avoid memory leaks.
- Consider async/event-bus variants for larger systems.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
