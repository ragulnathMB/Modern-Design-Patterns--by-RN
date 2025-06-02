#include<bits/stdc++.h>
using namespace std;

// Abstract class
class AbstractProcess{
    public:
        virtual void execute(){
            step1();
            step2();
            step3();
        }
        // abstract steps
        virtual void step1()=0;
        virtual void step2()=0;
    
        // Hooks or Common steps
        virtual void step3(){
            // Common steps
            cout<<"this is a common step"<<endl;
        }
        virtual ~AbstractProcess(){}

};

// Concrete class
class SpecialProcess: public AbstractProcess{
    public:
        void step1() override{
            cout<<"This is a unique step 1 for Special Process"<<endl;
        }
        void step2() override{
            cout<<"This is a unique step 2 for special Process"<<endl;
        }
};

int main(){
    AbstractProcess* specialProcess = new SpecialProcess();
    specialProcess->execute();

    delete specialProcess;

    return 0;
}