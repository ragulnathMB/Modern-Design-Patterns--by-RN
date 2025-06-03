#include<bits/stdc++.h>
using namespace std;

// Abstract Handler
class Handler{
    protected:
        shared_ptr<Handler> next;
    public:
        virtual ~Handler(){}
        virtual void setNext(shared_ptr<Handler> n){
            next=n;
        }

        virtual void handleRequest(int level)=0;
};

// Concrete Handlers
class BasicHandler: public Handler{
    public:
        void handleRequest(int level) override{
            if(level==1){
                cout<<"Basic handler is handling request of level 1"<<endl;
            }else if(next){
                next->handleRequest(level);
            }else{
                cout<<"The level "<<level<<" cannot be handled by any Handlers"<<endl;
            }
        }
};
class ModerateHandler: public Handler{
    public:
        void handleRequest(int level) override{
            if(level==2){
                cout<<"Moderate handler is handling request of level 2"<<endl;
            }else if(next){
                next->handleRequest(level);
            }else{
                cout<<"The level "<<level<<" cannot be handled by any Handlers"<<endl;
            }
        }
};
class AdvancedHandler: public Handler{
    public:
        void handleRequest(int level) override{
            if(level==3){
                cout<<"Advanced handler is handling request of level 3"<<endl;
            }else if(next){
                next->handleRequest(level);
            }else{
                cout<<"The level "<<level<<" cannot be handled by any Handlers"<<endl;
            }
        }
};

int main(){
    shared_ptr<Handler> basic = make_shared<BasicHandler>();
    shared_ptr<Handler> moderate = make_shared<ModerateHandler>();
    shared_ptr<Handler> advanced = make_shared<AdvancedHandler>();

    basic->setNext(moderate);
    moderate->setNext(advanced);

    basic->handleRequest(1);
    moderate->handleRequest(2);
    basic->handleRequest(3);
    advanced->handleRequest(4); // cannot handle
    return 0;
}