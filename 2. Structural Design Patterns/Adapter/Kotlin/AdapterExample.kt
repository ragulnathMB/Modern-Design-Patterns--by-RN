// Adapter Pattern Example in Kotlin
// RoundHole accepts RoundPeg. Adapt SquarePeg via an adapter.

interface RoundPeg { fun getRadius(): Double }
class SimpleRoundPeg(private val r: Double) : RoundPeg { override fun getRadius() = r }
class RoundHole(private val r: Double) { fun fits(p: RoundPeg) = p.getRadius() <= r }
class SquarePeg(val w: Double)
class SquarePegAdapter(private val peg: SquarePeg) : RoundPeg { override fun getRadius() = (peg.w * Math.sqrt(2.0)) / 2.0 }

fun main(){
    val hole = RoundHole(5.0)
    println(hole.fits(SimpleRoundPeg(5.0))) // true
    val small = SquarePeg(7.0)
    val large = SquarePeg(11.0)
    println(hole.fits(SquarePegAdapter(small)))
    println(hole.fits(SquarePegAdapter(large)))
}
