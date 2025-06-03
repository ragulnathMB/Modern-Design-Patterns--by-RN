#include <iostream>
using namespace std;

// Component Interface
class Component {
public:
    virtual void operation() = 0;
    virtual ~Component() {}
};

// Concrete Component
class ConcreteComponent : public Component {
public:
    void operation() override {
        cout << "ConcreteComponent operation\n";
    }
};

// Base Decorator
class Decorator : public Component {
protected:
    Component* component;
public:
    Decorator(Component* comp) : component(comp) {}
    void operation() override {
        component->operation();
    }

    virtual ~Decorator() {
        delete component;  // Ensure proper cleanup
    }
};
