#include<bits/stdc++.h>
using namespace std;

// Strategy Interface;
class Strategy{
    public:
        virtual void execute()=0;
        virtual ~Strategy(){}
};

// Concrete Strategy A
class ConcreteStrategyA: public Strategy{
    public:
        void execute() override{
            cout<<"Some action is executed using ConcreteStrategyA"<<endl;
        }
};
class ConcreteStrategyB: public Strategy{
    public:
        void execute() override{
            cout<<"Some action is executed using ConcreteStrategyB"<<endl;
        }
};

// Context
class Context{
    private:
        Strategy* strategy;
    public:
        Context(Strategy*s): strategy(s){}

        void setStrategy(Strategy*s){
            strategy=s;
        }
        void executeStrategy(){
            strategy->execute();
        }
};

int main(){
    Strategy* concreteStrategyA=new ConcreteStrategyA();
    Strategy* concreteStrategyB= new ConcreteStrategyB();

    Context* context = new Context(concreteStrategyA);
    context->executeStrategy();

    context->setStrategy(concreteStrategyB);
    context->executeStrategy();

    delete concreteStrategyA;
    delete concreteStrategyB;
    delete context;
    return 0;
}