// Prototype Pattern – TypeScript Example
interface Shape {
  clone(): Shape;
  draw(): void;
}

class Rectangle implements Shape {
  constructor(
    public x = 0,
    public y = 0,
    public width = 0,
    public height = 0,
    public color = ''
  ) {}
  clone(): Shape {
    return new Rectangle(this.x, this.y, this.width, this.height, this.color);
  }
  draw(): void {
    console.log(`Rectangle: ${this.x},${this.y},${this.width},${this.height} color=${this.color}`);
  }
}

class Circle implements Shape {
  constructor(
    public x = 0,
    public y = 0,
    public radius = 0,
    public color = ''
  ) {}
  clone(): Shape {
    return new Circle(this.x, this.y, this.radius, this.color);
  }
  draw(): void {
    console.log(`Circle: ${this.x},${this.y},r=${this.radius} color=${this.color}`);
  }
}

const rect1 = new Rectangle(10, 20, 30, 40, 'red');
const rect2 = rect1.clone() as Rectangle;
rect2.x += 100;
rect1.draw();
rect2.draw();
