 # Proxy Pattern

 The Proxy pattern provides a surrogate or placeholder for another object to control access to it. A proxy can defer heavy initialization (virtual proxy), enforce access control (protection proxy), add caching or logging (smart proxy), or manage remote access (remote proxy).

 ## When to Use
 - You need to control access to an object (authorization, lazy init, rate limiting, logging, caching).
 - The real object is heavy to create or remote to access; a proxy can delay or optimize interactions.
 - You want to add cross-cutting behavior around a subject without changing its interface.

 ## Example Overview
 Example models a simple image viewer.
 - Subject: `Image` interface exposes `display()`.
 - Real Subject: `RealImage` loads an image from disk on first use (expensive).
 - Proxy: `ProxyImage` holds filename and creates the `RealImage` lazily upon first `display()`, then delegates subsequent calls.

 Benefits: clients use `Image` uniformly; lazy loading avoids unnecessary heavy operations.

 ## Key Points
 - Proxy implements the same interface as the real subject and controls access to it.
 - Variants include virtual, protection, remote, and smart proxies.
 - Keep the proxy small; heavy logic goes into the real subject or separate services.

 The repository includes example and template implementations across C#, Go, Java, JavaScript, Kotlin, Rust, TypeScript, and C++.

