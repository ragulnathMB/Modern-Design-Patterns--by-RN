#include<bits/stdc++.h>
using namespace std;

// Abstract Products
class AbstractProductA{
    public:
        virtual void operationA()=0;
        virtual ~AbstractProductA(){}
};
class AbstractProductB{
    public:
        virtual void operationB()=0;
        virtual ~AbstractProductB(){}
};

// Abstract Factory
class AbstractFactory{
    public:
        virtual AbstractProductA* createProductA()=0;
        virtual AbstractProductB* createProductB()=0;
        virtual ~AbstractFactory(){}
};

// Concrete Products
class ConcreteProductA: public AbstractProductA{
    public:
        void operationA() override{
            cout<<"Performing some operations from ConcreteProductA"<<endl;
        }
};
class ConcreteProductB: public AbstractProductB{
    public:
        void operationB() override{
            cout<<"Performing some operations from ConcreteProductB"<<endl;
        }
};

// Concrete Factory
class ConcreteFactory1: public AbstractFactory{
    public:
        AbstractProductA* createProductA() override{
            return new ConcreteProductA();
        }
        AbstractProductB* createProductB() override{
            return new ConcreteProductB();
        }
};
// Similary you can make many concrete products ans their respective factories

int main(){
    AbstractFactory* factory1=new ConcreteFactory1();
    AbstractProductA* productA=factory1->createProductA();
    AbstractProductB* productB=factory1->createProductB();
    productA->operationA();
    productB->operationB();

    delete factory1;
    delete productA;
    delete productB;
    return 0;
}