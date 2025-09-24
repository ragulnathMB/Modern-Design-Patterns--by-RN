#include <iostream>
#include <string>
#include <vector>
using namespace std;

// Memento class
class Memento {
private:
    string state;

public:
    Memento(const string& s) : state(s) {}
    string getState() const { return state; }
};

// Originator class
class Originator {
private:
    string state;

public:
    void setState(const string& s) { state = s; }
    string getState() const { return state; }

    Memento saveToMemento() { return Memento(state); }
    void restoreFromMemento(const Memento& m) { state = m.getState(); }
};

// Caretaker class
class Caretaker {
private:
    vector<Memento> mementos;

public:
    void addMemento(const Memento& m) { mementos.push_back(m); }
    Memento getMemento(int index) { return mementos.at(index); }
};
