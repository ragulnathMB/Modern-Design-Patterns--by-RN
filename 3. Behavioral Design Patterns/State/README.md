# State Pattern

The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

## When to Use
- An object's behavior depends on its state, and it must change behavior at runtime.
- You have large conditional statements that depend on the object's state.
- You want to avoid duplicate code across similar states and transitions.

## Example Overview
Example: a `TrafficLight` that cycles through Red, Yellow, and Green states.
- Context: `TrafficLight` holds current state and delegates operations to it.
- State: `TrafficLightState` interface defines `next()` and `getColor()`.
- Concrete States: `RedState`, `YellowState`, `GreenState` implement transitions and behavior.

## Key Points
- States encapsulate state-specific behavior and know about transitions.
- Context delegates to current state; states can change the context's state.
- Eliminates large switch/if statements and makes adding new states easier.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
