// Adapter Pattern – TypeScript Template
// Target expects request(); Adaptee exposes specificRequest(); Adapter bridges them.

declare const console: any;

interface Target { request(): void }

class Adaptee {
  specificRequest(): void { /* ... */ }
}

class Adapter implements Target {
  private adaptee = new Adaptee()
  request(): void { this.adaptee.specificRequest() }
}

// Usage:
// const t: Target = new Adapter();
// t.request();
