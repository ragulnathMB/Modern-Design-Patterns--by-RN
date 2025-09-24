// Prototype Pattern – Java Example
interface Shape extends Cloneable { Shape clone(); void draw(); }
class Rectangle implements Shape {
    int x,y,w,h; String color;
    Rectangle(){}
    Rectangle(Rectangle r){ this.x=r.x; this.y=r.y; this.w=r.w; this.h=r.h; this.color=r.color; }
    public Shape clone(){ return new Rectangle(this);} 
    public void draw(){ System.out.println("Rectangle:"+x+","+y+","+w+","+h+" color="+color); }
}
class Circle implements Shape {
    int x,y,r; String color;
    Circle(){}
    Circle(Circle c){ this.x=c.x; this.y=c.y; this.r=c.r; this.color=c.color; }
    public Shape clone(){ return new Circle(this);} 
    public void draw(){ System.out.println("Circle:"+x+","+y+",r="+r+" color="+color); }
}
public class PrototypeExample{
    public static void main(String[] args){ Rectangle rect=new Rectangle(); rect.x=10; rect.y=20; rect.w=30; rect.h=40; rect.color="red"; Rectangle copy=(Rectangle)rect.clone(); copy.x+=100; rect.draw(); copy.draw(); }
}
