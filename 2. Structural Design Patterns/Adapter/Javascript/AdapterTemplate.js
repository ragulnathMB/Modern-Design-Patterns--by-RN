// Adapter Pattern – JavaScript Template
// Target expects request(); Adaptee has specificRequest(); Adapter bridges them.

class Target {
  request() {}
}

class Adaptee {
  specificRequest() { /* ... */ }
}

class Adapter extends Target {
  constructor() {
    super();
    this.adaptee = new Adaptee();
  }
  request() {
    this.adaptee.specificRequest();
  }
}

// Usage: const t = new Adapter(); t.request();
