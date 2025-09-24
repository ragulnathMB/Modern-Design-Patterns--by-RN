// Proxy Pattern Example in JavaScript
// Image viewer with lazy-loading proxy

class Image { display(){} }
class RealImage extends Image { constructor(filename){ super(); this.filename = filename; console.log(`Loading image: ${filename}`); } display(){ console.log(`Displaying: ${this.filename}`); } }
class ProxyImage extends Image { constructor(filename){ super(); this.filename = filename; this.real = null; } display(){ if(!this.real) this.real = new RealImage(this.filename); this.real.display(); } }

(function main(){ let img = new ProxyImage('photo.jpg'); img.display(); img.display(); })();
