// Adapter Pattern Example in Java
// RoundHole fits RoundPeg. Adapt SquarePeg via an adapter.

interface IRoundPeg { double getRadius(); }
class RoundPeg implements IRoundPeg { private final double r; RoundPeg(double r){ this.r=r; } public double getRadius(){ return r; } }
class RoundHole { private final double r; RoundHole(double r){ this.r=r; } boolean fits(IRoundPeg p){ return p.getRadius() <= r; } }
class SquarePeg { final double w; SquarePeg(double w){ this.w=w; } }
class SquarePegAdapter implements IRoundPeg { private final SquarePeg peg; SquarePegAdapter(SquarePeg p){ this.peg=p; } public double getRadius(){ return (peg.w*Math.sqrt(2))/2.0; } }
public class AdapterExample {
    public static void main(String[] args){
        RoundHole hole = new RoundHole(5);
        System.out.println(hole.fits(new RoundPeg(5)));
        SquarePeg small = new SquarePeg(7);
        SquarePeg large = new SquarePeg(11);
        System.out.println(hole.fits(new SquarePegAdapter(small)));
        System.out.println(hole.fits(new SquarePegAdapter(large)));
    }
}
