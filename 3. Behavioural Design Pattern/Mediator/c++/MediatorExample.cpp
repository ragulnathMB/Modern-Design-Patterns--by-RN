#include <iostream>
#include <memory>
#include <string>
using namespace std;

// Forward declaration
class Colleague;

// Mediator Interface
class Mediator {
public:
    virtual void sendMessage(const string& message, Colleague* sender) = 0;
};

// Base Colleague class
class Colleague {
protected:
    Mediator* mediator;  // Raw pointer is fine here, no ownership

public:
    Colleague(Mediator* m) : mediator(m) {}
    virtual void send(const string& message) = 0;
    virtual void receive(const string& message) = 0;
};

// Concrete Colleague 1
class User1 : public Colleague {
public:
    User1(Mediator* m) : Colleague(m) {}

    void send(const string& message) override {
        cout << "User1 sends: " << message << endl;
        mediator->sendMessage(message, this);
    }

    void receive(const string& message) override {
        cout << "User1 receives: " << message << endl;
    }
};

// Concrete Colleague 2
class User2 : public Colleague {
public:
    User2(Mediator* m) : Colleague(m) {}

    void send(const string& message) override {
        cout << "User2 sends: " << message << endl;
        mediator->sendMessage(message, this);
    }

    void receive(const string& message) override {
        cout << "User2 receives: " << message << endl;
    }
};

// Concrete Mediator
class ChatMediator : public Mediator {
private:
    User1* user1;
    User2* user2;

public:
    void setUsers(User1* u1, User2* u2) {
        user1 = u1;
        user2 = u2;
    }

    void sendMessage(const string& message, Colleague* sender) override {
        if (sender == user1 && user2) {
            user2->receive(message);
        } else if (sender == user2 && user1) {
            user1->receive(message);
        }
    }
};

// Main
int main() {
    ChatMediator mediator;

    User1 u1(&mediator);
    User2 u2(&mediator);

    mediator.setUsers(&u1, &u2);

    u1.send("Hello, User2!");
    u2.send("Hi, User1! How's it going?");

    return 0;
}
