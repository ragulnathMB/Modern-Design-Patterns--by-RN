#include<bits/stdc++.h>
using namespace std;

// Product Interface
class Product{
    public:
        virtual void use()=0;
        virtual ~Product(){};
};

// Concrete Products
class ConcreteProductA: public Product{
    public:
        void use() override{
            cout<<"Using Product A"<<endl;
        }
};
class ConcreteProductB: public Product{
    public:
        void use() override{
            cout<<"Using Product B"<<endl;
        }
};

// Factory(Creator) Interface
class Creator{
    public:
        virtual Product* create()=0;
        virtual ~Creator(){}
};

// Concrete Creators
class ConcreteCreatorA: public Creator{
    public:
        Product*create() override{
            return new ConcreteProductA;
        }
};
class ConcreteCreatorB: public Creator{
    public:
        Product*create()override{
            return new ConcreteProductB;
        }
};

int main(){
    Creator* factory; // You can use single as well as multiple factory pointers according to the situation
    factory=new ConcreteCreatorA();
    Product*product1=factory->create();
    product1->use();

    factory=new ConcreteCreatorB();
    Product*product2=factory->create();
    product2->use();

    delete factory;
    delete product1;
    delete product2;
    return 0;
}