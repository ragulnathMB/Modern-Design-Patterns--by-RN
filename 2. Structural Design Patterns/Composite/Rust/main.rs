// Composite Pattern Example in Rust
// File system: File (leaf) and Directory (composite)

trait FSItem {
    fn display(&self, depth: usize);
    fn size(&self) -> usize;
}

struct FSFile { name: String, size: usize }
impl FSItem for FSFile {
    fn display(&self, depth: usize) {
        println!("{}File: {} ({}KB)", " ".repeat(depth*2), self.name, self.size);
    }
    fn size(&self) -> usize { self.size }
}

struct Directory { name: String, items: Vec<Box<dyn FSItem>> }
impl Directory { fn add(&mut self, item: Box<dyn FSItem>) { self.items.push(item) } }
impl FSItem for Directory {
    fn display(&self, depth: usize) {
        println!("{}Directory: {}/", " ".repeat(depth*2), self.name);
        for it in &self.items { it.display(depth+1); }
    }
    fn size(&self) -> usize { self.items.iter().map(|i| i.size()).sum() }
}

fn main(){
    let mut root = Directory { name: "root".into(), items: vec![] };
    let mut docs = Directory { name: "docs".into(), items: vec![] };
    docs.add(Box::new(FSFile { name: "readme.txt".into(), size: 5 }));
    docs.add(Box::new(FSFile { name: "manual.pdf".into(), size: 150 }));
    root.add(Box::new(docs));
    root.add(Box::new(FSFile { name: "config.ini".into(), size: 2 }));
    root.display(0);
    println!("Total size: {}KB", root.size());
}
