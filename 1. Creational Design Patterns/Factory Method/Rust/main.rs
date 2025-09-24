// Factory Method – Rust Example
trait Transport {
    fn deliver(&self);
}

struct Truck;
impl Transport for Truck {
    fn deliver(&self) {
        println!("Deliver by land in a box.");
    }
}

struct Ship;
impl Transport for Ship {
    fn deliver(&self) {
        println!("Deliver by sea in a container.");
    }
}

trait Logistics {
    fn create_transport(&self) -> Box<dyn Transport>;
    fn plan_delivery(&self) {
        self.create_transport().deliver();
    }
}

struct RoadLogistics;
impl Logistics for RoadLogistics {
    fn create_transport(&self) -> Box<dyn Transport> { Box::new(Truck) }
}

struct SeaLogistics;
impl Logistics for SeaLogistics {
    fn create_transport(&self) -> Box<dyn Transport> { Box::new(Ship) }
}

fn main() {
    let log: Box<dyn Logistics> = if std::env::args().any(|a| a == "sea") {
        Box::new(SeaLogistics)
    } else {
        Box::new(RoadLogistics)
    };

    log.plan_delivery();
}
