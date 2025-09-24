// Composite Pattern Example in JavaScript
// File system: File (leaf) and Directory (composite)

class FileItem {
  constructor(name, size){ this.name = name; this.size = size; }
  display(depth=0){ console.log(`${' '.repeat(depth*2)}File: ${this.name} (${this.size}KB)`); }
  getSize(){ return this.size; }
}

class Directory {
  constructor(name){ this.name = name; this.items = []; }
  add(item){ this.items.push(item); }
  remove(item){ this.items = this.items.filter(x => x !== item); }
  display(depth=0){
    console.log(`${' '.repeat(depth*2)}Directory: ${this.name}/`);
    for(const it of this.items) it.display(depth+1);
  }
  getSize(){ return this.items.reduce((t,it)=>t+it.getSize(),0); }
}

(function main(){
  const root = new Directory('root');
  const docs = new Directory('docs');
  docs.add(new FileItem('readme.txt',5));
  docs.add(new FileItem('manual.pdf',150));
  root.add(docs);
  root.add(new FileItem('config.ini',2));
  root.display();
  console.log(`Total size: ${root.getSize()}KB`);
})();
