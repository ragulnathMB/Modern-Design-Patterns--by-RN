#include <iostream>
#include <unordered_map>
#include <memory>
using namespace std;

// Flyweight class
class Flyweight {
private:
    string intrinsicState; // shared state
public:
    Flyweight(const string& state) : intrinsicState(state) {}

    void operation(const string& extrinsicState) {
        cout << "Flyweight with intrinsic state [" << intrinsicState
             << "] and extrinsic state [" << extrinsicState << "]\n";
    }
};

// Flyweight Factory
class FlyweightFactory {
private:
    unordered_map<string, shared_ptr<Flyweight>> flyweights;
public:
    shared_ptr<Flyweight> getFlyweight(const string& key) {
        if (flyweights.find(key) == flyweights.end()) {
            flyweights[key] = make_shared<Flyweight>(key);
            cout << "Creating new Flyweight for key: " << key << endl;
        }
        return flyweights[key];
    }

    void listFlyweights() {
        cout << "\nTotal Flyweights created: " << flyweights.size() << endl;
        for (auto& pair : flyweights) {
            cout << " - " << pair.first << endl;
        }
    }
};
