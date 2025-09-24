// Bridge Pattern Example in TypeScript
// Abstraction: Remote; Implementor: Device (TV/Radio)

declare const console: any;

enum Clamp {
  Min = 0,
  Max = 100,
}

interface Device {
  isEnabled(): boolean;
  enable(): void;
  disable(): void;
  setVolume(v: number): void;
  getVolume(): number;
}

class TV implements Device {
  private on = false;
  private vol = 10;
  isEnabled() { return this.on; }
  enable() { this.on = true; }
  disable() { this.on = false; }
  setVolume(v: number) { this.vol = Math.max(Clamp.Min, Math.min(Clamp.Max, v)); }
  getVolume() { return this.vol; }
}

class Radio implements Device {
  private on = false;
  private vol = 20;
  isEnabled() { return this.on; }
  enable() { this.on = true; }
  disable() { this.on = false; }
  setVolume(v: number) { this.vol = Math.max(Clamp.Min, Math.min(Clamp.Max, v)); }
  getVolume() { return this.vol; }
}

class Remote {
  constructor(protected device: Device) {}
  togglePower() { this.device.isEnabled() ? this.device.disable() : this.device.enable(); }
  volumeUp() { this.device.setVolume(this.device.getVolume() + 10); }
  volumeDown() { this.device.setVolume(this.device.getVolume() - 10); }
}

class AdvancedRemote extends Remote {
  mute() { this.device.setVolume(0); }
}

const tv: Device = new TV();
const r = new Remote(tv);
r.togglePower(); r.volumeUp();
console.log('TV on=', tv.isEnabled(), 'vol=', tv.getVolume());

const radio: Device = new Radio();
const ar = new AdvancedRemote(radio);
ar.togglePower(); ar.mute();
console.log('Radio on=', radio.isEnabled(), 'vol=', radio.getVolume());
