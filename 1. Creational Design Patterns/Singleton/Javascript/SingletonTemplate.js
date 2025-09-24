// Singleton Pattern – JavaScript Template (Node)
class Singleton {
  constructor() {
    if (Singleton._instance) return Singleton._instance;
    Singleton._instance = this;
  }
  static getInstance() {
    return Singleton._instance || new Singleton();
  }
}
// Usage: const s = Singleton.getInstance();
