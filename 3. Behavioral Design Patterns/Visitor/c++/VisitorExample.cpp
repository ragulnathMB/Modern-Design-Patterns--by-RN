#include <iostream>
#include <vector>
#include <memory>
using namespace std;

// Forward declarations
class Developer;
class Manager;

// Visitor Interface
class Visitor {
public:
    virtual void visit(Developer* dev) = 0;
    virtual void visit(Manager* mgr) = 0;
    virtual ~Visitor() {}
};

// Element Interface
class Employee {
public:
    virtual void accept(Visitor* visitor) = 0;
    virtual ~Employee() {}
};

// Concrete Element: Developer
class Developer : public Employee {
public:
    string name;
    int linesOfCode;

    Developer(string n, int loc) : name(n), linesOfCode(loc) {}

    void accept(Visitor* visitor) override {
        visitor->visit(this);
    }
};

// Concrete Element: Manager
class Manager : public Employee {
public:
    string name;
    int teamSize;

    Manager(string n, int team) : name(n), teamSize(team) {}

    void accept(Visitor* visitor) override {
        visitor->visit(this);
    }
};

// Concrete Visitor 1: Salary Calculator
class SalaryCalculatorVisitor : public Visitor {
public:
    void visit(Developer* dev) override {
        cout << dev->name << "'s salary: $" << (dev->linesOfCode * 0.5) << endl;
    }

    void visit(Manager* mgr) override {
        cout << mgr->name << "'s salary: $" << (mgr->teamSize * 1000) << endl;
    }
};

// Concrete Visitor 2: Promotion Evaluator
class PromotionEvaluatorVisitor : public Visitor {
public:
    void visit(Developer* dev) override {
        if (dev->linesOfCode > 1000)
            cout << dev->name << " is eligible for promotion!" << endl;
        else
            cout << dev->name << " needs more work for promotion." << endl;
    }

    void visit(Manager* mgr) override {
        if (mgr->teamSize >= 5)
            cout << mgr->name << " is eligible for promotion!" << endl;
        else
            cout << mgr->name << " needs to handle a larger team." << endl;
    }
};
int main() {
    vector<unique_ptr<Employee>> employees;

    employees.push_back(make_unique<Developer>("Alice", 1200));
    employees.push_back(make_unique<Manager>("Bob", 3));
    employees.push_back(make_unique<Developer>("Charlie", 800));
    employees.push_back(make_unique<Manager>("Diana", 6));

    SalaryCalculatorVisitor salaryVisitor;
    PromotionEvaluatorVisitor promotionVisitor;

    cout << "=== Salaries ===" << endl;
    for (auto& emp : employees) {
        emp->accept(&salaryVisitor);
    }

    cout << "\n=== Promotion Evaluation ===" << endl;
    for (auto& emp : employees) {
        emp->accept(&promotionVisitor);
    }

    return 0;
}
