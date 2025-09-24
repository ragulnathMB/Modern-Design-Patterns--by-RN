// Prototype Pattern – Kotlin Example
abstract class Shape(var x:Int=0,var y:Int=0,var color:String=""){ abstract fun clone(): Shape; abstract fun draw() }
class Rectangle(x:Int=0,y:Int=0,var width:Int=0,var height:Int=0,color:String=""): Shape(x,y,color){
    override fun clone() = Rectangle(x,y,width,height,color)
    override fun draw() = println("Rectangle: $x,$y,$width,$height color=$color")
}
class Circle(x:Int=0,y:Int=0,var radius:Int=0,color:String=""): Shape(x,y,color){
    override fun clone() = Circle(x,y,radius,color)
    override fun draw() = println("Circle: $x,$y r=$radius color=$color")
}
fun main(){ val rect1=Rectangle(10,20,30,40,"red"); val rect2=rect1.clone() as Rectangle; rect2.x+=100; rect1.draw(); rect2.draw() }
