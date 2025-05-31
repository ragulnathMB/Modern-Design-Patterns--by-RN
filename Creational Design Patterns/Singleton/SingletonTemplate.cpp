#include<bits/stdc++.h>
using namespace std;

class Singleton{
    private:
        static Singleton* instance;
        Singleton(){}
    
    public:
        Singleton(const Singleton&)=delete; //Delete or disable copy constructor
        Singleton& operator=(const Singleton&)=delete; //Delete or disable assignment operator
        
        static Singleton* getInstance(){
            if(instance==nullptr){
                instance=new Singleton();
            }
            return instance;
        }

        void showMessage(){
            cout<<"Single instance with address: "<<&instance<<endl;
        }
};

Singleton* Singleton::instance=nullptr;

int main(){
    Singleton* object1=Singleton::getInstance();
    object1->showMessage();
    Singleton* object2=Singleton::getInstance();
    object2->showMessage();
    return 0;
}