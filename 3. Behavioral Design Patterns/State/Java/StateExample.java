// State Pattern Example in Java
// TrafficLight cycles through Red, Yellow, Green states

interface TrafficLightState { void next(TrafficLight context); String getColor(); }

class TrafficLight {
    private TrafficLightState state;
    TrafficLight(){ state = new RedState(); }
    void setState(TrafficLightState s){ state = s; }
    void next(){ state.next(this); }
    String getColor(){ return state.getColor(); }
}

class RedState implements TrafficLightState { public void next(TrafficLight t){ t.setState(new GreenState()); } public String getColor(){ return "Red"; } }
class YellowState implements TrafficLightState { public void next(TrafficLight t){ t.setState(new RedState()); } public String getColor(){ return "Yellow"; } }
class GreenState implements TrafficLightState { public void next(TrafficLight t){ t.setState(new YellowState()); } public String getColor(){ return "Green"; } }

public class StateExample {
    public static void main(String[] args){
        TrafficLight light = new TrafficLight();
        for(int i=0;i<6;i++){ System.out.println("Light: " + light.getColor()); light.next(); }
    }
}
