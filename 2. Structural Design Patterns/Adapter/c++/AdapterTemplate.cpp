#include<bits/stdc++.h>
using namespace std;

// Target Interface
class Target{
    public:
        virtual void request()=0;
        virtual ~Target(){}
};
// Adaptee
class Adaptee{
    public:
        void specificRequest(){
            cout<<"Some specific Request"<<endl;
        }
};

// Adpater
class Adapter: public Target{
    private:
        Adaptee* adaptee;
    public:
        Adapter(Adaptee* a): adaptee(a){}
        void request() override{
            adaptee->specificRequest(); // convet to expected interface
        }
};

int main(){
    Adaptee* adaptee = new Adaptee();
    Adapter* adapter = new Adapter(adaptee);

    adapter->request();

    delete adaptee;
    delete adapter;

    return 0;
}