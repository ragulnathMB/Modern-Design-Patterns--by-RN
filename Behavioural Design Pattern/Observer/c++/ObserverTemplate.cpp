#include<bits/stdc++.h>
using namespace std;

// Observer
class Observer{
    public:
        virtual void update(int val)=0;
};
// Concrete Observer
class ConcreteObserver: public Observer{
    public:
        void update(int val) override{
            cout<<"State has been update to: "<<val<<endl;
        }
};

// Subject
class Subject{
    private:
        vector<Observer*> observersList;
        int state;
        void notify(){
            for(auto obs:observersList){
                obs->update(state);
            }
        }
    public:
        void attachObserver(Observer* obs){
            observersList.push_back(obs);
        }
        void deleteObserver(Observer* obs){
            // Safely delete the observer
            observersList.erase(remove(observersList.begin(),observersList.end(),obs),observersList.end());
        }
        void updateState(int val){
            state=val;
            notify();
        }
        int getState(){
            return this->state;
        }
};

int main(){
    Observer*obs1=new ConcreteObserver();
    Observer*obs2=new ConcreteObserver();

    Subject* sub=new Subject();
    sub->attachObserver(obs1);
    sub->attachObserver(obs2);

    sub->updateState(30);

    delete obs1;
    delete obs2;
    delete sub;

    return 0;
}


