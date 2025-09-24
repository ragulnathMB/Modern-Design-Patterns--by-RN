#include <iostream>
#include <vector>
#include <memory>
using namespace std;

// Forward declaration
template<typename T>
class Iterator;

// Aggregate Interface
template<typename T>
class Iterable {
public:
    virtual shared_ptr<Iterator<T>> createIterator() = 0;
};

// Iterator Interface
template<typename T>
class Iterator {
public:
    virtual bool hasNext() = 0;
    virtual T next() = 0;
};
