#include <iostream>
using namespace std;

// Implementation Interface
class Implementation {
public:
    virtual void operationImpl() = 0;
    virtual ~Implementation() {}
};

// Concrete Implementations
class ConcreteImplA : public Implementation {
public:
    void operationImpl() override {
        cout << "ConcreteImplA operation\n";
    }
};

class ConcreteImplB : public Implementation {
public:
    void operationImpl() override {
        cout << "ConcreteImplB operation\n";
    }
};

// Abstraction
class Abstraction {
protected:
    Implementation* impl;
public:
    Abstraction(Implementation* impl) : impl(impl) {}
    virtual void operation() {
        impl->operationImpl();
    }
    virtual ~Abstraction() {}
};

// Refined Abstraction
class RefinedAbstraction : public Abstraction {
public:
    RefinedAbstraction(Implementation* impl) : Abstraction(impl) {}
    void operation() override {
        cout << "RefinedAbstraction delegates to ";
        impl->operationImpl();
    }
};
