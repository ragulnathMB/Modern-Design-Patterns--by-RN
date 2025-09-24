// Observer Pattern Example in Rust
// WeatherStation notifies Display observers when temperature changes

trait Observer {
    fn update(&self, temperature: f32);
}

struct WeatherStation {
    observers: Vec<Box<dyn Observer>>,
    temperature: f32,
}

impl WeatherStation {
    fn new() -> Self { Self { observers: Vec::new(), temperature: 0.0 } }
    fn attach(&mut self, o: Box<dyn Observer>) { self.observers.push(o) }
    fn notify(&self) { for o in &self.observers { o.update(self.temperature) } }
    fn set_temperature(&mut self, temp: f32) { self.temperature = temp; self.notify() }
}

struct PhoneDisplay;
impl Observer for PhoneDisplay { fn update(&self, temp: f32) { println!("Phone: Temperature is {:.1}°C", temp) } }

struct WindowDisplay;
impl Observer for WindowDisplay { fn update(&self, temp: f32) { println!("Window: Temperature is {:.1}°C", temp) } }

fn main(){
    let mut station = WeatherStation::new();
    station.attach(Box::new(PhoneDisplay));
    station.attach(Box::new(WindowDisplay));
    station.set_temperature(25.5);
    station.set_temperature(30.2);
}
