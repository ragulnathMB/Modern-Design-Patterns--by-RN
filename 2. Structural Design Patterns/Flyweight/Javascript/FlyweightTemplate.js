// Flyweight Pattern – JavaScript Template

class Flyweight {
  // intrinsic, immutable data
}

class FlyweightFactory {
  static cache = new Map();
  static get(key){
    if(!this.cache.has(key)) this.cache.set(key, new Flyweight());
    return this.cache.get(key);
  }
}

class Context {
  constructor(key){ this.fw = FlyweightFactory.get(key); }
  operation(/* extrinsic params */){ /* use this.fw + extrinsic */ }
}

(function main(){ new Context('key').operation(); })();
