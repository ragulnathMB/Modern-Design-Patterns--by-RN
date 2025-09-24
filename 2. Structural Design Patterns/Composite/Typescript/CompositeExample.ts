// Composite Pattern Example in TypeScript
// File system: File (leaf) and Directory (composite)

interface FSItem { display(depth?: number): void; getSize(): number }

class FSFile implements FSItem {
  constructor(private name: string, private size: number) {}
  display(depth: number = 0): void { console.log(`${' '.repeat(depth*2)}File: ${this.name} (${this.size}KB)`); }
  getSize(): number { return this.size }
}

class Directory implements FSItem {
  private items: FSItem[] = []
  constructor(private name: string) {}
  add(item: FSItem){ this.items.push(item) }
  remove(item: FSItem){ this.items = this.items.filter(x=>x!==item) }
  display(depth: number = 0){
    console.log(`${' '.repeat(depth*2)}Directory: ${this.name}/`)
    for(const it of this.items) it.display(depth+1)
  }
  getSize(): number { return this.items.reduce((t,it)=>t+it.getSize(),0) }
}

(function main(){
  const root = new Directory('root')
  const docs = new Directory('docs')
  docs.add(new FSFile('readme.txt', 5))
  docs.add(new FSFile('manual.pdf', 150))
  root.add(docs)
  root.add(new FSFile('config.ini', 2))
  root.display()
  console.log(`Total size: ${root.getSize()}KB`)
})()
