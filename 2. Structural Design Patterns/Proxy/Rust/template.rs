// Proxy Pattern – Rust Template (with mutability for lazy init)

trait Subject { fn request(&mut self); }

struct RealSubject;
impl RealSubject { fn new() -> Self { Self } }
impl Subject for RealSubject { fn request(&mut self){ /* heavy work */ } }

struct Proxy { real: Option<RealSubject> }
impl Proxy { fn new() -> Self { Self { real: None } } }
impl Subject for Proxy {
    fn request(&mut self) {
        if self.real.is_none() { self.real = Some(RealSubject::new()); }
        if let Some(real) = self.real.as_mut() { /* checks/logging */ real.request(); }
    }
}

fn main(){ let mut s = Proxy::new(); s.request(); }
