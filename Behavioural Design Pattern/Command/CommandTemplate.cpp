#include<bits/stdc++.h>
using namespace std;

// receiver
class Receiver{
    public:
        void action(){
            cout<<"Receiver does some action"<<endl;
        }
};

// Abstract command
class Command{
    public:
        virtual void execute()=0;
        virtual ~Command(){}
};
// Concrete Command
class ConcreteCommand: public Command{
    private:
        Receiver*receiver;
    public:
        ConcreteCommand(Receiver* r): receiver(r){}

        void execute() override{
            receiver->action();
        }
};
// Invoker
class Invoke{
    private:
        Command* command;
    public:
        Invoke(Command*c): command(c){}

        void executeCommand(){
            command->execute();
        }
};

int main(){
    Receiver* receiver = new Receiver();

    Command* command = new ConcreteCommand(receiver);
    Invoke* invoker = new Invoke(command);
    invoker->executeCommand();

    delete receiver;
    delete command;
    delete invoker;

    return 0;
}