// Builder Pattern – Java Example
// Build a Car using step-by-step builder.

class Car {
    String engine;
    int wheels;
    String color;
    public String toString() { return "Car{"+engine+","+wheels+","+color+"}"; }
}

interface CarBuilder {
    void buildEngine();
    void buildWheels();
    void paint();
    Car getResult();
}

class SportsCarBuilder implements CarBuilder {
    private final Car car = new Car();
    public void buildEngine() { car.engine = "V8"; }
    public void buildWheels() { car.wheels = 4; }
    public void paint() { car.color = "Red"; }
    public Car getResult() { return car; }
}

class Director {
    void construct(CarBuilder b) {
        b.buildEngine();
        b.buildWheels();
        b.paint();
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        CarBuilder builder = new SportsCarBuilder();
        new Director().construct(builder);
        System.out.println(builder.getResult());
    }
}
