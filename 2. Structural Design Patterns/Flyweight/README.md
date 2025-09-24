 # Flyweight Pattern

 The Flyweight pattern minimizes memory usage by sharing as much data as possible with similar objects. It separates intrinsic (shared, immutable) state from extrinsic (context-specific) state passed in at runtime.

 ## When to Use
 - You have a large number of similar objects that would be expensive to keep in memory.
 - Most of each object's state can be made shared and immutable (intrinsic), with only small per-use data (extrinsic) varying.
 - You want to centralize and reuse heavy data (e.g., sprite, formatting, glyph, tree type) across many lightweight objects.

 ## Example Overview
 Example models a forest rendering system.
 - Flyweight: `TreeType` stores intrinsic state like name, color, and texture.
 - Factory: `TreeFactory` returns shared `TreeType` instances by key.
 - Context: `Tree` holds extrinsic state (x, y) and references a `TreeType` to draw.
 - Client: `Forest` creates and draws many trees while reusing a small set of `TreeType` objects.

 Benefits: drastically fewer heavy objects, lower memory footprint, and faster creation.

 ## Key Points
 - Intrinsic state must be immutable and shareable.
 - Extrinsic state is supplied by the client each time and not stored inside the flyweight.
 - Use a factory to manage and cache flyweights.

 The repository includes example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.

