// Factory Method – Java Example
interface Transport {
    void deliver();
}

class Truck implements Transport {
    public void deliver() {
        System.out.println("Deliver by land in a box.");
    }
}

class Ship implements Transport {
    public void deliver() {
        System.out.println("Deliver by sea in a container.");
    }
}

abstract class Logistics {
    void planDelivery() {
        Transport t = createTransport();
        t.deliver();
    }

    abstract Transport createTransport();
}

class RoadLogistics extends Logistics {
    Transport createTransport() { return new Truck(); }
}

class SeaLogistics extends Logistics {
    Transport createTransport() { return new Ship(); }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        Logistics log = (args.length > 0 && args[0].equals("sea"))
                ? new SeaLogistics()
                : new RoadLogistics();
        log.planDelivery();
    }
}
