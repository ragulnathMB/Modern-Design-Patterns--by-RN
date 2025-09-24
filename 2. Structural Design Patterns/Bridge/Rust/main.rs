// Bridge Pattern Example in Rust
// Abstraction: Remote; Implementor: Device (TV/Radio)

trait Device {
    fn is_enabled(&self) -> bool;
    fn enable(&mut self);
    fn disable(&mut self);
    fn set_volume(&mut self, v: i32);
    fn get_volume(&self) -> i32;
}

struct TV { on: bool, vol: i32 }
impl Device for TV {
    fn is_enabled(&self) -> bool { self.on }
    fn enable(&mut self) { self.on = true }
    fn disable(&mut self) { self.on = false }
    fn set_volume(&mut self, mut v: i32) { if v < 0 { v = 0 } if v > 100 { v = 100 } self.vol = v }
    fn get_volume(&self) -> i32 { self.vol }
}

struct Radio { on: bool, vol: i32 }
impl Device for Radio {
    fn is_enabled(&self) -> bool { self.on }
    fn enable(&mut self) { self.on = true }
    fn disable(&mut self) { self.on = false }
    fn set_volume(&mut self, mut v: i32) { if v < 0 { v = 0 } if v > 100 { v = 100 } self.vol = v }
    fn get_volume(&self) -> i32 { self.vol }
}

// Abstraction
struct Remote<D: Device> { device: D }
impl<D: Device> Remote<D> {
    fn new(device: D) -> Self { Self { device } }
    fn toggle_power(&mut self) { if self.device.is_enabled() { self.device.disable() } else { self.device.enable() } }
    fn volume_up(&mut self) { let v = self.device.get_volume() + 10; self.device.set_volume(v) }
    fn volume_down(&mut self) { let v = self.device.get_volume() - 10; self.device.set_volume(v) }
}

// Refined Abstraction
struct AdvancedRemote<D: Device>(Remote<D>);
impl<D: Device> AdvancedRemote<D> {
    fn new(device: D) -> Self { Self(Remote::new(device)) }
    fn mute(&mut self) { self.0.device.set_volume(0) }
}

fn main() {
    let mut tv_remote = Remote::new(TV { on: false, vol: 10 });
    tv_remote.toggle_power();
    tv_remote.volume_up();
    println!("TV on={} vol={}", tv_remote.device.is_enabled(), tv_remote.device.get_volume());

    let mut radio_remote = AdvancedRemote::new(Radio { on: false, vol: 20 });
    radio_remote.0.toggle_power();
    radio_remote.mute();
    println!("Radio on={} vol={}", radio_remote.0.device.is_enabled(), radio_remote.0.device.get_volume());
}
