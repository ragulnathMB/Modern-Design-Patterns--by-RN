#include <iostream>
using namespace std;

// Forward declarations
class ElementA;
class ElementB;

// Visitor interface
class Visitor {
public:
    virtual void visit(ElementA* element) = 0;
    virtual void visit(ElementB* element) = 0;
    virtual ~Visitor() {}
};

// Element interface
class Element {
public:
    virtual void accept(Visitor* visitor) = 0;
    virtual ~Element() {}
};

// Concrete Element A
class ElementA : public Element {
public:
    void accept(Visitor* visitor) override {
        visitor->visit(this);
    }

    void operationA() {
        cout << "Operation specific to ElementA" << endl;
    }
};

// Concrete Element B
class ElementB : public Element {
public:
    void accept(Visitor* visitor) override {
        visitor->visit(this);
    }

    void operationB() {
        cout << "Operation specific to ElementB" << endl;
    }
};
