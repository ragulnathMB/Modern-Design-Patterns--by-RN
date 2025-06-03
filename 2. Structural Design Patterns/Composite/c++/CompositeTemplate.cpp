#include <iostream>
#include <vector>
using namespace std;

// Component
class Component {
public:
    virtual void operation() = 0;
    virtual void add(Component* component) {}
    virtual void remove(Component* component) {}
    virtual ~Component() {}
};

// Leaf
class Leaf : public Component {
public:
    void operation() override {
        cout << "Leaf operation\n";
    }
};

// Composite
class Composite : public Component {
private:
    vector<Component*> children;
public:
    void operation() override {
        cout << "Composite operation\n";
        for (auto child : children)
            child->operation();
    }

    void add(Component* component) override {
        children.push_back(component);
    }

    void remove(Component* component) override {
        children.erase(remove(children.begin(), children.end(), component), children.end());
    }

    ~Composite() {
        for (auto child : children)
            delete child;
    }
};
