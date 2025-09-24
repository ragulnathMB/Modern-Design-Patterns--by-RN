// Flyweight Pattern Example in JavaScript
// Forest: share TreeType (intrinsic) among many Tree instances (extrinsic position)

class TreeType {
  constructor(name, color, texture){ this.name = name; this.color = color; this.texture = texture; }
  draw(x, y){ console.log(`Draw ${this.name} [${this.color},${this.texture}] at (${x},${y})`); }
}

class TreeFactory {
  static cache = new Map();
  static getTreeType(name, color, texture){
    const key = `${name}-${color}-${texture}`;
    if(!this.cache.has(key)) this.cache.set(key, new TreeType(name, color, texture));
    return this.cache.get(key);
  }
}

class Tree {
  constructor(x, y, type){ this.x = x; this.y = y; this.type = type; }
  draw(){ this.type.draw(this.x, this.y); }
}

class Forest {
  constructor(){ this.trees = []; }
  plant(x, y, name, color, texture){ const type = TreeFactory.getTreeType(name, color, texture); this.trees.push(new Tree(x,y,type)); }
  draw(){ for(const t of this.trees) t.draw(); }
}

(function main(){
  const forest = new Forest();
  for(let i=0;i<5;i++) forest.plant(i, i*2, 'Oak', 'Green', 'Rough');
  for(let i=0;i<3;i++) forest.plant(i+10, i*3, 'Pine', 'DarkGreen', 'Smooth');
  forest.draw();
})();
