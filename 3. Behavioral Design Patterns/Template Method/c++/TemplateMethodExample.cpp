#include<bits/stdc++.h>
using namespace std;

// Abstract class with template mehtod
class Cooking{
    public:
        virtual void cookMeal(){
            boilWater();
            addIngredients();
            cook();
            serve();
        }
        // common methods
        virtual void boilWater(){
            cout<<"Water is boiling in the container"<<endl;
        }
        virtual void serve(){
            cout<<"Serve the dish in plate"<<endl;
        }
        // unique methods
        virtual void addIngredients()=0;
        virtual void cook()=0;
};

// Concrete classes with abstract method
class CookRice: public Cooking{
    public:
        void addIngredients() override{
            cout<<"Add rice to the container"<<endl;
        }
        void cook() override{
            cout<<"Cook rice for 20 minutes"<<endl;
        }
};
class CookPasta: public Cooking{
    public:
        void addIngredients() override{
            cout<<"Add pasta to the container"<<endl;
        }
        void cook() override{
            cout<<"Cook pasta for 10 minutes"<<endl;
        }
};

int main(){
    
    Cooking * cookRice = new CookRice();
    cookRice->cookMeal();

    Cooking * cookPasta = new CookPasta();
    cookPasta->cookMeal();

    delete cookRice;
    delete cookPasta;

    return 0;
}