#include <iostream>
using namespace std;

// Implementation: Device
class Device {
public:
    virtual void turnOn() = 0;
    virtual void turnOff() = 0;
    virtual ~Device() {}
};

class TV : public Device {
public:
    void turnOn() override {
        cout << "Turning on the TV\n";
    }
    void turnOff() override {
        cout << "Turning off the TV\n";
    }
};

class Radio : public Device {
public:
    void turnOn() override {
        cout << "Turning on the Radio\n";
    }
    void turnOff() override {
        cout << "Turning off the Radio\n";
    }
};

// Abstraction: RemoteControl
class RemoteControl {
protected:
    Device* device;
public:
    RemoteControl(Device* d) : device(d) {}
    virtual void on() {
        device->turnOn();
    }
    virtual void off() {
        device->turnOff();
    }
    virtual ~RemoteControl() {}
};

// Refined Abstraction: AdvancedRemote
class AdvancedRemote : public RemoteControl {
public:
    AdvancedRemote(Device* d) : RemoteControl(d) {}

    void mute() {
        cout << "Muting the device\n";
    }
};

int main() {
    TV tv;
    Radio radio;

    RemoteControl* remote1 = new RemoteControl(&tv);
    remote1->on();
    remote1->off();

    AdvancedRemote* remote2 = new AdvancedRemote(&radio);
    remote2->on();
    remote2->mute();
    remote2->off();

    delete remote1;
    delete remote2;

    return 0;
}
