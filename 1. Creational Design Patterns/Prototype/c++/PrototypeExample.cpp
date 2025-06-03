#include<bits/stdc++.h>
using namespace std;

// Prototype Interface
class Prototype{
    public:
        virtual Prototype* clone()=0;
        virtual void action()=0;
        virtual ~Prototype(){}
};

// Concrete Prototype
class ConcretePrototypeA: public Prototype{
    public:
        ConcretePrototypeA(int val): value(val){}
        Prototype* clone() override{
            return new ConcretePrototypeA(*this);
        }
        void action() override{
            cout<<"ConcretePrototypeA with value: "<<value<<" has performed some action."<<endl;
        }
    private:
        int value;
};

class ConcretePrototypeB: public Prototype{
    public:
        ConcretePrototypeB(int val): value(val){}
        Prototype* clone() override{
            return new ConcretePrototypeB(*this);
        }
        void action() override{
            cout<<"ConcretePrototypeB with value: "<<value<<" has performed some action."<<endl;
        }
    private:
        int value;
};

// Prototype Registry to create and manage prototypes
class PrototypeResgistry{
    private:
        map<string,Prototype*>registry;
    public:
        void registerPrototype(string prototypeName,Prototype* prototype){
            registry[prototypeName]=prototype;
        }
        Prototype* getClone(string prototypeName){
            return registry[prototypeName]->clone();
        }
};




int main(){
    // Register your prototypes
    PrototypeResgistry* registry=new PrototypeResgistry();
    registry->registerPrototype("PrototypeA",new ConcretePrototypeA(100));
    registry->registerPrototype("PrototypeB",new ConcretePrototypeB(80));

    // Perform some actions
    Prototype*prototype1=registry->getClone("PrototypeA");
    prototype1->action();

    Prototype*prototype2 = registry->getClone("PrototypeB");
    prototype2->action();

    delete registry;
    delete prototype1;
    delete prototype2;

    return 0;
}