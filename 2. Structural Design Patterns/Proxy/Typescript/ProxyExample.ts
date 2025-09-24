// Proxy Pattern Example in TypeScript
// Image viewer with lazy-loading proxy

interface Image { display(): void }

class RealImage implements Image {
  constructor(private filename: string){ console.log(`Loading image: ${filename}`) }
  display(): void { console.log(`Displaying: ${this.filename}`) }
}

class ProxyImage implements Image {
  private real: RealImage | null = null
  constructor(private filename: string){}
  display(): void {
    if (!this.real) this.real = new RealImage(this.filename)
    this.real.display()
  }
}

;(function main(){ const img: Image = new ProxyImage('photo.jpg'); img.display(); img.display() })()

export {}
