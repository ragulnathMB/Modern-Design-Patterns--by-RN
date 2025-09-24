#include <iostream>
#include <memory>
using namespace std;

// Forward declaration
class Context;

// Abstract State
class State {
public:
    virtual void handle(Context* context) = 0;
    virtual ~State() {}
};

// Context class
class Context {
private:
    unique_ptr<State> state;

public:
    Context(State* initialState) : state(initialState) {}

    void setState(State* newState) {
        state.reset(newState);
    }

    void request() {
        state->handle(this);
    }
};
