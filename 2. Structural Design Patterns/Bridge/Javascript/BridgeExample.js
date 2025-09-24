// Bridge Pattern Example in JavaScript
// Abstraction: Remote; Implementor: Device (TV/Radio)

class Device {
  isEnabled() { return false }
  enable() {}
  disable() {}
  setVolume(v) {}
  getVolume() { return 0 }
}

class TV extends Device {
  constructor(){ super(); this.on=false; this.vol=10 }
  isEnabled(){ return this.on }
  enable(){ this.on=true }
  disable(){ this.on=false }
  setVolume(v){ this.vol = Math.max(0, Math.min(100, v)) }
  getVolume(){ return this.vol }
}

class Radio extends Device {
  constructor(){ super(); this.on=false; this.vol=20 }
  isEnabled(){ return this.on }
  enable(){ this.on=true }
  disable(){ this.on=false }
  setVolume(v){ this.vol = Math.max(0, Math.min(100, v)) }
  getVolume(){ return this.vol }
}

class Remote {
  constructor(device){ this.device = device }
  togglePower(){ this.device.isEnabled() ? this.device.disable() : this.device.enable() }
  volumeUp(){ this.device.setVolume(this.device.getVolume()+10) }
  volumeDown(){ this.device.setVolume(this.device.getVolume()-10) }
}

class AdvancedRemote extends Remote {
  mute(){ this.device.setVolume(0) }
}

const tv = new TV();
const r = new Remote(tv);
r.togglePower(); r.volumeUp();
console.log('TV on=', tv.isEnabled(), 'vol=', tv.getVolume());

const radio = new Radio();
const ar = new AdvancedRemote(radio);
ar.togglePower(); ar.mute();
console.log('Radio on=', radio.isEnabled(), 'vol=', radio.getVolume());
