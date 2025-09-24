// Adapter Pattern Example in TypeScript
// RoundHole fits RoundPeg. Adapt SquarePeg to RoundPeg interface via adapter.

declare const console: any;

interface RoundPeg { getRadius(): number }

class SimpleRoundPeg implements RoundPeg {
  constructor(private r: number) {}
  getRadius(): number { return this.r }
}

class RoundHole {
  constructor(public r: number) {}
  fits(p: RoundPeg): boolean { return p.getRadius() <= this.r }
}

class SquarePeg { constructor(public w: number) {} }

class SquarePegAdapter implements RoundPeg {
  constructor(private peg: SquarePeg) {}
  getRadius(): number { return (this.peg.w * Math.SQRT2) / 2 }
}

const hole = new RoundHole(5)
console.log(hole.fits(new SimpleRoundPeg(5)))
const small = new SquarePeg(7)
const large = new SquarePeg(11)
console.log(hole.fits(new SquarePegAdapter(small)))
console.log(hole.fits(new SquarePegAdapter(large)))
