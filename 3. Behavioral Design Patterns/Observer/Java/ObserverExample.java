// Observer Pattern Example in Java
// WeatherStation notifies Display observers when temperature changes

import java.util.*;

interface Observer { void update(float temperature); }
interface Subject { void attach(Observer o); void detach(Observer o); void notifyObservers(); }

class WeatherStation implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;
    public void attach(Observer o){ observers.add(o); }
    public void detach(Observer o){ observers.remove(o); }
    public void notifyObservers(){ for (Observer o : observers) o.update(temperature); }
    public void setTemperature(float temp){ temperature = temp; notifyObservers(); }
}

class PhoneDisplay implements Observer { public void update(float temp){ System.out.printf("Phone: Temperature is %.1f°C%n", temp); } }
class WindowDisplay implements Observer { public void update(float temp){ System.out.printf("Window: Temperature is %.1f°C%n", temp); } }

public class ObserverExample {
    public static void main(String[] args){
        WeatherStation station = new WeatherStation();
        PhoneDisplay phone = new PhoneDisplay();
        WindowDisplay window = new WindowDisplay();
        station.attach(phone);
        station.attach(window);
        station.setTemperature(25.5f);
        station.setTemperature(30.2f);
    }
}
