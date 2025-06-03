#include <iostream>
#include <string>
#include <memory>
using namespace std;

// Forward declaration
class Mediator;

// Base class for colleagues
class Colleague {
protected:
    shared_ptr<Mediator> mediator;

public:
    Colleague(shared_ptr<Mediator> m) : mediator(m) {}
    virtual void send(const string& message) = 0;
    virtual void receive(const string& message) = 0;
};

// Mediator interface
class Mediator {
public:
    virtual void sendMessage(const string& message, shared_ptr<Colleague> sender) = 0;
};
