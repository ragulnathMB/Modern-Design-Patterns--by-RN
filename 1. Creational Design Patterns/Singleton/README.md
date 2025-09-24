# Singleton Pattern

The Singleton pattern ensures a class has only one instance and provides a global access point to it.

## When to Use
- There must be exactly one instance, and it must be accessible from a well-known access point.
- The instance manages shared resources (configuration, logging, connection pool, etc.).

## Caveats
- Overuse of Singletons can introduce global state and tight coupling. Prefer dependency injection where possible.
- Thread-safety matters: use language-idiomatic lazy initialization (Lazy<T> in C#, static holder in Java, sync.Once in Go, object in Kotlin, OnceLock in Rust).
- Testing can be harder due to hidden dependencies.
