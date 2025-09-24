// Factory Method – TypeScript Example
declare const process: any;

interface Transport {
  deliver(): void;
}

class Truck implements Transport {
  deliver() {
    console.log('Deliver by land in a box.');
  }
}

class Ship implements Transport {
  deliver() {
    console.log('Deliver by sea in a container.');
  }
}

abstract class Logistics {
  planDelivery() {
    this.createTransport().deliver();
  }

  protected abstract createTransport(): Transport;
}

class RoadLogistics extends Logistics {
  protected createTransport(): Transport {
    return new Truck();
  }
}

class SeaLogistics extends Logistics {
  protected createTransport(): Transport {
    return new Ship();
  }
}

const logistics: Logistics = process.argv[2] === 'sea'
  ? new SeaLogistics()
  : new RoadLogistics();

logistics.planDelivery();
