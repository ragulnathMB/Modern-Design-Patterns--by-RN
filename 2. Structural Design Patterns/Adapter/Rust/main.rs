// Adapter Pattern Example in Rust
// RoundHole fits RoundPeg. Adapt SquarePeg via an adapter implementing RoundPeg.

struct RoundHole { r: f64 }
impl RoundHole {
    fn fits<P: RoundPeg>(&self, peg: &P) -> bool { peg.radius() <= self.r }
}

trait RoundPeg { fn radius(&self) -> f64; }

struct SimpleRoundPeg { r: f64 }
impl RoundPeg for SimpleRoundPeg { fn radius(&self) -> f64 { self.r } }

struct SquarePeg { w: f64 }

struct SquarePegAdapter { peg: SquarePeg }
impl RoundPeg for SquarePegAdapter {
    fn radius(&self) -> f64 { (self.peg.w * 2_f64.sqrt()) / 2.0 }
}

fn main(){
    let hole = RoundHole{ r: 5.0 };
    let round = SimpleRoundPeg{ r: 5.0 };
    println!("{}", hole.fits(&round));
    let small = SquarePeg{ w: 7.0 };
    let large = SquarePeg{ w: 11.0 };
    println!("{}", hole.fits(&SquarePegAdapter{ peg: small }));
    println!("{}", hole.fits(&SquarePegAdapter{ peg: large }));
}
