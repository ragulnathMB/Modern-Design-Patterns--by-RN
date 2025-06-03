#include <iostream>
using namespace std;

// Subject interface
class Subject {
public:
    virtual void request() = 0;
    virtual ~Subject() {}
};

// Real Subject
class RealSubject : public Subject {
public:
    void request() override {
        cout << "RealSubject: Handling request." << endl;
    }
};

// Proxy
class Proxy : public Subject {
private:
    RealSubject* realSubject;

public:
    Proxy() : realSubject(nullptr) {}

    ~Proxy() {
        delete realSubject;
    }

    void request() override {
        if (!realSubject) {
            realSubject = new RealSubject();
            cout << "Proxy: Created RealSubject." << endl;
        }
        cout << "Proxy: Delegating request to RealSubject." << endl;
        realSubject->request();
    }
};
