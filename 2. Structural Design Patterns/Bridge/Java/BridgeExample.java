// Bridge Pattern Example in Java
// Abstraction: Remote; Implementor: Device (TV/Radio)

interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    void setVolume(int v);
    int getVolume();
}

class TV implements Device {
    private boolean on; private int vol = 10;
    public boolean isEnabled(){ return on; }
    public void enable(){ on = true; }
    public void disable(){ on = false; }
    public void setVolume(int v){ vol = Math.max(0, Math.min(100, v)); }
    public int getVolume(){ return vol; }
}

class Radio implements Device {
    private boolean on; private int vol = 20;
    public boolean isEnabled(){ return on; }
    public void enable(){ on = true; }
    public void disable(){ on = false; }
    public void setVolume(int v){ vol = Math.max(0, Math.min(100, v)); }
    public int getVolume(){ return vol; }
}

class Remote {
    protected final Device device;
    Remote(Device d){ this.device = d; }
    void togglePower(){ if (device.isEnabled()) device.disable(); else device.enable(); }
    void volumeUp(){ device.setVolume(device.getVolume()+10); }
    void volumeDown(){ device.setVolume(device.getVolume()-10); }
}

class AdvancedRemote extends Remote {
    AdvancedRemote(Device d){ super(d); }
    void mute(){ device.setVolume(0); }
}

public class BridgeExample {
    public static void main(String[] args){
        Device tv = new TV();
        Remote r = new Remote(tv);
        r.togglePower(); r.volumeUp();
        System.out.println("TV on="+tv.isEnabled()+" vol="+tv.getVolume());

        Device radio = new Radio();
        AdvancedRemote ar = new AdvancedRemote(radio);
        ar.togglePower(); ar.mute();
        System.out.println("Radio on="+radio.isEnabled()+" vol="+radio.getVolume());
    }
}
