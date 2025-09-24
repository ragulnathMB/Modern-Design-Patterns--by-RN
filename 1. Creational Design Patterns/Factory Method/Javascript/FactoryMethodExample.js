// Factory Method – JavaScript Example
class Transport {
  deliver() {}
}

class Truck extends Transport {
  deliver() {
    console.log('Deliver by land in a box.');
  }
}

class Ship extends Transport {
  deliver() {
    console.log('Deliver by sea in a container.');
  }
}

class Logistics {
  planDelivery() {
    const t = this.createTransport();
    t.deliver();
  }

  createTransport() {}
}

class RoadLogistics extends Logistics {
  createTransport() {
    return new Truck();
  }
}

class SeaLogistics extends Logistics {
  createTransport() {
    return new Ship();
  }
}

const logistics = process.argv[2] === 'sea'
  ? new SeaLogistics()
  : new RoadLogistics();

logistics.planDelivery();
