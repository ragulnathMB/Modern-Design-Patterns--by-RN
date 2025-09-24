# Command Pattern

The Command pattern turns a request into a stand‑alone object that contains all information about the request. This lets you parameterize methods with different requests, queue or log requests, and support undoable operations.

## When to Use
- You want to decouple senders (invokers) from receivers.
- You want to queue, schedule, or log operations uniformly.
- You want to support undo/redo by storing inverse operations and/or state.

## Example Overview
Example: a simple remote control that can execute commands on devices (a `Light` and a `Stereo`).
- Command: `Command` interface with `execute()` (and optional `undo()`).
- Concrete Commands: `LightOnCommand`, `LightOffCommand`, `StereoOnCommand`, `StereoOffCommand` store receiver and implement `execute()`.
- Receiver: `Light`, `Stereo` provide actual operations.
- Invoker: `RemoteButton` holds a `Command` and calls `execute()`.

## Key Points
- Commands encapsulate receiver + action; invokers don't need to know receiver details.
- You can queue commands, compose macro commands, and add undo/redo.
- Keep commands small; complex logic belongs to receivers or dedicated services.

This folder provides example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.
