// Adapter Pattern Example in JavaScript
// RoundHole fits RoundPeg. Adapt SquarePeg using an adapter implementing getRadius().

class RoundHole {
  constructor(radius) { this.radius = radius; }
  fits(peg) { return peg.getRadius() <= this.radius; }
}

class RoundPeg {
  constructor(radius) { this.radius = radius; }
  getRadius() { return this.radius; }
}

class SquarePeg { constructor(width){ this.width = width; } }

class SquarePegAdapter {
  constructor(peg) { this.peg = peg; }
  getRadius() { return (this.peg.width * Math.SQRT2) / 2; }
}

const hole = new RoundHole(5);
console.log(hole.fits(new RoundPeg(5)));
const small = new SquarePeg(7);
const large = new SquarePeg(11);
console.log(hole.fits(new SquarePegAdapter(small)));
console.log(hole.fits(new SquarePegAdapter(large)));
