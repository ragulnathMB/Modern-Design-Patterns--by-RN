// Proxy Pattern – JavaScript Template

class Subject { request(){} }
class RealSubject extends Subject { request(){ /* heavy work */ } }
class Proxy extends Subject { constructor(){ super(); this.real = null; } request(){ if(!this.real) this.real = new RealSubject(); /* checks/logging */ this.real.request(); } }

(function main(){ const s = new Proxy(); s.request(); })();
