#include<bits/stdc++.h>
using namespace std;

// Abstract Handler
class Handler{
    protected:
        shared_ptr<Handler> next;
    public:
        virtual ~Handler(){}

        void setNext(shared_ptr<Handler> n){
            next=n;
        }
        virtual void handleRequest(int request)=0;
};

int main(){
    return 0;
}