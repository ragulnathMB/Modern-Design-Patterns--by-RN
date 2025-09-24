// State Pattern Example in Rust
// TrafficLight cycles through Red, Yellow, Green states

trait TrafficLightState {
    fn next(self: Box<Self>) -> Box<dyn TrafficLightState>;
    fn get_color(&self) -> &str;
}

struct TrafficLight { state: Box<dyn TrafficLightState> }
impl TrafficLight {
    fn new() -> Self { Self { state: Box::new(RedState) } }
    fn next(&mut self) { let old_state = std::mem::replace(&mut self.state, Box::new(RedState)); self.state = old_state.next(); }
    fn get_color(&self) -> &str { self.state.get_color() }
}

struct RedState;
impl TrafficLightState for RedState { fn next(self: Box<Self>) -> Box<dyn TrafficLightState> { Box::new(GreenState) } fn get_color(&self) -> &str { "Red" } }

struct YellowState;
impl TrafficLightState for YellowState { fn next(self: Box<Self>) -> Box<dyn TrafficLightState> { Box::new(RedState) } fn get_color(&self) -> &str { "Yellow" } }

struct GreenState;
impl TrafficLightState for GreenState { fn next(self: Box<Self>) -> Box<dyn TrafficLightState> { Box::new(YellowState) } fn get_color(&self) -> &str { "Green" } }

fn main(){
    let mut light = TrafficLight::new();
    for _ in 0..6 { println!("Light: {}", light.get_color()); light.next(); }
}
