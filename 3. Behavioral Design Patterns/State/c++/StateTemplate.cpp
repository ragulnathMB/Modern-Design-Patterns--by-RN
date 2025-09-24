#include <iostream>
#include <memory>
using namespace std;

// Forward declaration
class State;
class OffState;
class LowState;
class HighState;
class Fan;

// Context: Fan
class Fan {
private:
    unique_ptr<State> state;

public:
    Fan(State* initialState);
    void setState(State* newState);
    void pressButton();
};

// Abstract State
class State {
public:
    virtual void pressButton(Fan* fan) = 0;
    virtual ~State() {}
};

// Concrete States
class OffState : public State {
public:
    void pressButton(Fan* fan) override;
};

class LowState : public State {
public:
    void pressButton(Fan* fan) override;
};

class HighState : public State {
public:
    void pressButton(Fan* fan) override;
};

// Fan implementation
Fan::Fan(State* initialState) : state(initialState) {}

void Fan::setState(State* newState) {
    state.reset(newState);
}

void Fan::pressButton() {
    state->pressButton(this);
}

// State Transitions
void OffState::pressButton(Fan* fan) {
    cout << "Fan turned to LOW speed." << endl;
    fan->setState(new LowState());
}

void LowState::pressButton(Fan* fan) {
    cout << "Fan turned to HIGH speed." << endl;
    fan->setState(new HighState());
}

void HighState::pressButton(Fan* fan) {
    cout << "Fan turned OFF." << endl;
    fan->setState(new OffState());
}

// Main
int main() {
    Fan fan(new OffState());

    fan.pressButton(); // OFF -> LOW
    fan.pressButton(); // LOW -> HIGH
    fan.pressButton(); // HIGH -> OFF
    fan.pressButton(); // OFF -> LOW

    return 0;
}
