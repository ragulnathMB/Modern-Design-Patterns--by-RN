// Adapter Pattern – Rust Template
// Target expects request(); Adaptee has specific_request(); Adapter bridges them.

trait Target { fn request(&self); }
struct Adaptee;
impl Adaptee { fn specific_request(&self) { /* ... */ } }

struct Adapter { adaptee: Adaptee }
impl Target for Adapter { fn request(&self) { self.adaptee.specific_request(); } }

fn main() { let t: Box<dyn Target> = Box::new(Adapter{ adaptee: Adaptee }); t.request(); }
