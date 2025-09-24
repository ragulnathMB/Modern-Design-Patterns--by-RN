// Builder Pattern – JavaScript Example
class House {
  constructor() {
    this.walls = '';
    this.roof = '';
    this.doors = '';
  }
  toString() {
    return `House: ${this.walls}, ${this.roof}, ${this.doors}`;
  }
}

class HouseBuilder {
  buildWalls() {}
  buildRoof() {}
  buildDoors() {}
  getResult() {}
}

class WoodenHouseBuilder extends HouseBuilder {
  constructor() { super(); this.house = new House(); }
  buildWalls() { this.house.walls = 'Wooden Walls'; }
  buildRoof() { this.house.roof = 'Wooden Roof'; }
  buildDoors() { this.house.doors = 'Wooden Doors'; }
  getResult() { return this.house; }
}

class Director {
  construct(builder) {
    builder.buildWalls();
    builder.buildRoof();
    builder.buildDoors();
  }
}

const builder = new WoodenHouseBuilder();
new Director().construct(builder);
console.log(builder.getResult().toString());
