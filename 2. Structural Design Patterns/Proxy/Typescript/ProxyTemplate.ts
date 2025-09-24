// Proxy Pattern – TypeScript Template

interface Subject { request(): void }
class RealSubject implements Subject { request(): void { /* heavy work */ } }
class Proxy implements Subject { private real: RealSubject | null = null; request(): void { if (!this.real) this.real = new RealSubject(); /* checks/logging */ this.real.request() } }

;(function main(){ const s: Subject = new Proxy(); s.request() })()

export {}
