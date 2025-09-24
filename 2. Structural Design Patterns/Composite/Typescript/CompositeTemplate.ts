// Composite Pattern – TypeScript Template

abstract class Component { abstract operation(): void }
class Leaf extends Component { operation(): void { /* ... */ } }
class Composite extends Component {
  private children: Component[] = []
  add(c: Component){ this.children.push(c) }
  remove(c: Component){ this.children = this.children.filter(x=>x!==c) }
  operation(): void { for(const ch of this.children) ch.operation() }
}
(function main(){ const root = new Composite(); root.add(new Leaf()); root.operation() })()
