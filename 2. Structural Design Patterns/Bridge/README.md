# Bridge Pattern

The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. It helps avoid a permanent binding between an abstraction and its implementation.

## When to Use
- You want to switch implementations at runtime without changing the abstraction.
- You want to share an implementation among multiple abstractions.
- You need to avoid a class explosion caused by combining multiple dimensions of variation.

## Example Overview
Abstraction: `Remote` and `AdvancedRemote` control devices.
Implementor: `Device` with concrete implementations `TV` and `Radio`.
Remotes operate on any `Device`, demonstrating how the abstraction and implementation vary independently.

