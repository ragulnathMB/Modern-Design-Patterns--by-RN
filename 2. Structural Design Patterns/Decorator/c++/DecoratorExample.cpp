#include <iostream>
#include <string>
using namespace std;

// Base Component
class Coffee {
public:
    virtual string getDescription() = 0;
    virtual double cost() = 0;
    virtual ~Coffee() {}
};

// Concrete Component
class BasicCoffee : public Coffee {
public:
    string getDescription() override {
        return "Basic Coffee";
    }

    double cost() override {
        return 5.0;
    }
};

// Base Decorator
class CoffeeDecorator : public Coffee {
protected:
    Coffee* coffee;
public:
    CoffeeDecorator(Coffee* c) : coffee(c) {}

    virtual ~CoffeeDecorator() {
        delete coffee;
    }
};

// Concrete Decorator: Milk
class MilkDecorator : public CoffeeDecorator {
public:
    MilkDecorator(Coffee* c) : CoffeeDecorator(c) {}

    string getDescription() override {
        return coffee->getDescription() + ", Milk";
    }

    double cost() override {
        return coffee->cost() + 1.5;
    }
};

// Concrete Decorator: Sugar
class SugarDecorator : public CoffeeDecorator {
public:
    SugarDecorator(Coffee* c) : CoffeeDecorator(c) {}

    string getDescription() override {
        return coffee->getDescription() + ", Sugar";
    }

    double cost() override {
        return coffee->cost() + 0.5;
    }
};

int main() {
    Coffee* myCoffee = new BasicCoffee();
    myCoffee = new MilkDecorator(myCoffee);
    myCoffee = new SugarDecorator(myCoffee);

    cout << "Order: " << myCoffee->getDescription() << endl;
    cout << "Total Cost: $" << myCoffee->cost() << endl;

    delete myCoffee;  // Clean up

    return 0;
}
