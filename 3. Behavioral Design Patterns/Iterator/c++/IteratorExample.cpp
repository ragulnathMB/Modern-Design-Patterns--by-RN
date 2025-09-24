#include <iostream>
#include <vector>
#include <memory>
using namespace std;

// Forward declaration
class IntIterator;

// Collection class
class IntCollection {
    vector<int> data;

public:
    void add(int value) {
        data.push_back(value);
    }

    friend class IntIterator;  // Allow iterator to access private data

    // Create an iterator for this collection
    shared_ptr<IntIterator> createIterator();
};

// Iterator class for IntCollection
class IntIterator {
    const IntCollection& collection;
    size_t index;

public:
    IntIterator(const IntCollection& col) : collection(col), index(0) {}

    bool hasNext() {
        return index < collection.data.size();
    }

    int next() {
        return collection.data[index++];
    }
};

// Implementation of createIterator()
shared_ptr<IntIterator> IntCollection::createIterator() {
    return make_shared<IntIterator>(*this);
}

// Main
int main() {
    IntCollection nums;
    nums.add(10);
    nums.add(20);
    nums.add(30);

    auto it = nums.createIterator();

    cout << "Iterating over IntCollection:\n";
    while (it->hasNext()) {
        cout << it->next() << " ";
    }
    cout << endl;

    return 0;
}
