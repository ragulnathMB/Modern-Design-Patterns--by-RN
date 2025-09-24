// Composite Pattern – JavaScript Template

class Component { operation(){} }
class Leaf extends Component { operation(){ /* ... */ } }
class Composite extends Component {
  constructor(){ super(); this.children = []; }
  add(c){ this.children.push(c); }
  remove(c){ this.children = this.children.filter(x=>x!==c); }
  operation(){ for(const ch of this.children) ch.operation(); }
}
(function main(){ const root = new Composite(); root.add(new Leaf()); root.operation(); })();
