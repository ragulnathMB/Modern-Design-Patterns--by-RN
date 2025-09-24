 # Composite Pattern

 The Composite pattern lets you compose objects into tree structures to represent part–whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

 ## When to Use
 - You need to represent part–whole hierarchies (e.g., UI components, file systems, organization charts).
 - Clients should treat simple and complex elements the same way (uniform access to `Component`).
 - You want to be able to add new element types (leaves or composites) without changing client code.

 ## Example Overview
 This example models a simple file system.
 - Component: `FileSystemItem`/`FSItem`/`Component` defines the common interface.
 - Leaf: `File`/`FSFile` represents files with a size; it implements operations directly.
 - Composite: `Directory`/`Folder` stores child items and delegates operations to them.

 Typical operations shown:
 - `display(depth)` to pretty‑print a tree.
 - `getSize()` to aggregate sizes across the tree (composite sums its children; leaf returns its own size).

 ## Key Points
 - Treat leaves and composites uniformly through a common interface.
 - Composites delegate work to children and can add behavior like aggregation before/after delegating.
 - Keep the Component interface minimal; optional child‑management operations can be on Composite only.

 The repository includes example and template code across multiple languages (C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, C++), demonstrating the same structure with language‑idiomatic patterns.

