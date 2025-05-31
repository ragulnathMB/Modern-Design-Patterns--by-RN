#include<bits/stdc++.h>
using namespace std;

// Product
class Car{
    public:
        void setEngine(const string& engine){
            carEngine = engine;
        }
        void setTyres(const string &tyre){
            carTyre = tyre;
        }
        void setSeats(int seats){
            carSeats = seats;
        }
        void getInfo(){
            cout<<"Engine : "<<carEngine<<endl;
            cout<<"Tyre type : "<<carTyre<<endl;
            cout<<"NO. of seats : "<<carSeats<<endl;
        }
    private:
        string carEngine;
        string carTyre;
        int carSeats;
};

// Abstract Builder
class CarBuilder{
    public:
        virtual ~CarBuilder(){}
        virtual void buildEngine()=0;
        virtual void buildTyre()=0;
        virtual void buildSeats()=0;
        virtual Car*getProduct()=0;
};

// Concrete Builder Class
class SportsCarBuilder: public CarBuilder{
    public:
        SportsCarBuilder(){
            car = new Car();
        }
        void buildEngine() override{
            car->setEngine("RX100");
        }
        void buildSeats() override{
            car->setSeats(4);
        }
        void buildTyre() override{
            car->setTyres("MRF");
        }
        Car* getProduct(){
            return car;
        }
        ~SportsCarBuilder(){
            delete car;
        }
    private:
        Car*car;
};

// Director
class CarDirector{
    public:
        Car* buildCar(CarBuilder* carBuilder){
            carBuilder->buildEngine();
            carBuilder->buildSeats();
            carBuilder->buildTyre();
            return carBuilder->getProduct();
        }
};

int main(){
    CarBuilder*sportCarBuilder = new SportsCarBuilder();
    CarDirector* director = new CarDirector();

    Car* resultCar = director->buildCar(sportCarBuilder);
    resultCar->getInfo();

    delete sportCarBuilder;
    delete director;
    delete resultCar;
}
