#include<bits/stdc++.h>
using namespace std;

// Receiver
class Light{
    public:
        void turnOn(){
            cout<<"Light is turned on"<<endl;
        }
        void turnOff(){
            cout<<"Light is turned off"<<endl;
        }
};

// Abstract command
class Command{
    public:
        virtual void execute()=0;
        virtual ~Command(){}
};
// Concrete Command
class TurnOnLight: public Command{
    private:
        Light* light;
    public:
        TurnOnLight(Light*l): light(l){}
        void execute() override{
                light->turnOn();
        }
};
class TurnOffLight: public Command{
    private:
        Light* light;
    public:
        TurnOffLight(Light*l): light(l){}
        void execute() override{
            light->turnOff();
        }
};

// Invoker
class RemoteController{
    private:
        Command* command;
    public:
        RemoteController(Command* c): command(c){}
        void setCommand(Command* c){
            command = c;
        }
        void executeCommand(){
            command->execute();
        }
};
int main(){
    Light* livingRoomLight = new Light();
    Command* turnOn = new TurnOnLight(livingRoomLight);
    Command* turnoff = new TurnOffLight(livingRoomLight);

    RemoteController* remote = new RemoteController(turnOn);
    remote->executeCommand();

    remote->setCommand(turnoff);
    remote->executeCommand();
    return 0;
}