#include <iostream>
using namespace std;

// Subsystem A
class SubsystemA {
public:
    void operationA() {
        cout << "SubsystemA: Operation A\n";
    }
};

// Subsystem B
class SubsystemB {
public:
    void operationB() {
        cout << "SubsystemB: Operation B\n";
    }
};

// Subsystem C
class SubsystemC {
public:
    void operationC() {
        cout << "SubsystemC: Operation C\n";
    }
};

// Facade
class Facade {
private:
    SubsystemA a;
    SubsystemB b;
    SubsystemC c;
public:
    void simpleOperation() {
        cout << "Facade: simpleOperation calls:\n";
        a.operationA();
        b.operationB();
        c.operationC();
    }
};
