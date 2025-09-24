// Flyweight Pattern Example in TypeScript
// Forest: shares TreeType (intrinsic) among many Tree instances (extrinsic position)

class TreeType {
  constructor(private name: string, private color: string, private texture: string) {}
  draw(x: number, y: number): void {
    console.log(`Draw ${this.name} [${this.color},${this.texture}] at (${x},${y})`)
  }
}

class TreeFactory {
  private static cache = new Map<string, TreeType>()
  static getTreeType(name: string, color: string, texture: string): TreeType {
    const key = `${name}-${color}-${texture}`
    if (!this.cache.has(key)) this.cache.set(key, new TreeType(name, color, texture))
    return this.cache.get(key) as TreeType
  }
}

class Tree {
  constructor(private x: number, private y: number, private type: TreeType) {}
  draw(): void { this.type.draw(this.x, this.y) }
}

class Forest {
  private trees: Tree[] = []
  plant(x: number, y: number, name: string, color: string, texture: string): void {
    const t = TreeFactory.getTreeType(name, color, texture)
    this.trees.push(new Tree(x, y, t))
  }
  draw(): void { for (const t of this.trees) t.draw() }
}

;(function main(){
  const forest = new Forest()
  for (let i=0;i<5;i++) forest.plant(i, i*2, 'Oak', 'Green', 'Rough')
  for (let i=0;i<3;i++) forest.plant(i+10, i*3, 'Pine', 'DarkGreen', 'Smooth')
  forest.draw()
})()

export {}
