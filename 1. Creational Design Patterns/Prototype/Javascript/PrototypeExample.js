// Prototype Pattern – JavaScript Example
class Shape {
  clone() { throw new Error('clone() not implemented'); }
  draw() {}
}
class Rectangle extends Shape {
  constructor(x=0,y=0,w=0,h=0,color='') { super(); Object.assign(this,{x,y,w,h,color}); }
  clone() { return new Rectangle(this.x,this.y,this.w,this.h,this.color); }
  draw(){ console.log(`Rectangle: ${this.x},${this.y},${this.w},${this.h} color=${this.color}`); }
}
class Circle extends Shape {
  constructor(x=0,y=0,r=0,color=''){ super(); Object.assign(this,{x,y,r,color}); }
  clone(){ return new Circle(this.x,this.y,this.r,this.color); }
  draw(){ console.log(`Circle: ${this.x},${this.y},r=${this.r} color=${this.color}`); }
}
const rect1=new Rectangle(10,20,30,40,'red'); const rect2=rect1.clone(); rect2.x+=100; rect1.draw(); rect2.draw();
