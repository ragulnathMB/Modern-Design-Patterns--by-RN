#include<bits/stdc++.h>
using namespace std;

// Observr
class Observer{
    public:
        virtual void update(int val)=0;
};
// Concrete Observers;
class WeatherDisplay: public Observer{
    private:
        int temperature;
    public:
        void update(int val) override{
            temperature=val;
            cout<<"Updated weather now in display : "<<temperature<<endl;
        }
};
class WeatherLogger: public Observer{
    private:
        int temperature;
    public:
        void update(int val) override{
            temperature=val;
            cout<<"Logged current temperature in Logger : "<<temperature<<endl;
        }

};

// Subject: Weather Station
class WeatherStation{
    private:
        vector<Observer*> observersList;
        int temperature;
        void notify(){
            for(auto obs: observersList){
                obs->update(temperature);
            }
        }
    public:
        void addObserver(Observer* obs){
            observersList.push_back(obs);
        }
        void deleteObserver(Observer* obs){
            observersList.erase(remove(observersList.begin(),observersList.end(),obs),observersList.end());
        }
        void update(int val){
            temperature=val;
            notify();
        }
};

int main(){
    // Observers
    Observer* logger = new WeatherLogger();
    Observer* displayBody = new WeatherDisplay();

    //Subject
    WeatherStation* station = new WeatherStation();
    station->addObserver(logger);
    station->addObserver(displayBody);
    station->update(32);

    delete logger;
    delete displayBody;
    delete station;


    return 0;
}