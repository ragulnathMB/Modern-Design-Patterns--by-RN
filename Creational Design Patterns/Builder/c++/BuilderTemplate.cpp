#include<bits/stdc++.h>
using namespace std;

// Product
class Product{
    public:
        void setPartA(const string& part){ partA=part; }
        void setPartB(const string& part){ partB=part; }
        void getInfo(){
            cout<<"Part A : "<<partA<<endl;
            cout<<"Part B : "<<partB<<endl;
        }
    private:
        string partA;
        string partB; 
};

// Abstract Builder
class Builder{
    public:
        virtual ~Builder(){}
        virtual void buildPartA()=0;
        virtual void buildPartB()=0;
        virtual Product* getProduct(){} 
};

// Concrete Builder
class ConcreteBuilder: public Builder{
    public:
        ConcreteBuilder(){
            product=new Product();
        }
        void buildPartA() override{
            product->setPartA("Engine");
        }
        void buildPartB() override{
            product->setPartB("Wings");
        }
        Product* getProduct(){
            return product;
        }
        ~ConcreteBuilder(){
            delete product;
        }

    private:
        Product*product;
};

// Director
class Director{
    public:
        Product* buildProduct(Builder* builder){
            builder->buildPartA();
            builder->buildPartB();
            return builder->getProduct();
        }
};

int main(){
    // Create your desired builder object
    Builder*builder = new ConcreteBuilder();
    Director*director = new Director();

    Product* product = director->buildProduct(builder);
    product->getInfo();

    delete builder;
    delete director;
    delete product;
}
