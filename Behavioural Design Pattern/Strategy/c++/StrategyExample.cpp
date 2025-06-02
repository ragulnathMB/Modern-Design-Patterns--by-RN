#include<bits/stdc++.h>
using namespace std;

// Strategy Interface
class Payment{
    public:
        virtual void pay(int val)=0;
        virtual ~Payment(){}
};

// Concrete payment strategies
class CreditCardPayment: public Payment{
    private:
        string creditInfo;
    public:
        CreditCardPayment(string info): creditInfo(info){}
        void pay(int val) override{
            cout<<"Payment of "<<val<<" done through credit card with info "<<creditInfo<<endl;
        }
};
class UPIPayment:public Payment{
    private:
        string UPI_Info;
    public:
        UPIPayment(string info):UPI_Info(info){}

        void pay(int val) override{
            cout<<"Payment of "<<val<<" done through UPI with info "<<UPI_Info<<endl;
        }
};

// payment context
class PaymentContext{
    private:
        Payment* payment;
    public:
        PaymentContext(Payment* p): payment(p){}

        void executePayment(int val){
            payment->pay(val);
        }
        void setPaymentStrategy(Payment* p){
            payment=p;
        }
};

int main(){
    Payment* payThroughCredit = new CreditCardPayment("CreditCardXXXX");
    Payment* payThroughUPI = new UPIPayment("UPI_IDXXXX");

    PaymentContext* context = new PaymentContext(payThroughCredit);
    context->executePayment(400);

    context->setPaymentStrategy(payThroughUPI);
    context->executePayment(500);
    
    delete payThroughCredit;
    delete payThroughUPI;
    delete context;
    return 0;
}