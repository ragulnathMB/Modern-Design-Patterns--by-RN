#include<bits/stdc++.h>
using namespace std;

// Target interface - what the modern systems are expecting
class ModernPrinter{
    public:
        virtual void printDocument(){
            cout<<"Printing the document"<<endl;
        }
        virtual ~ModernPrinter(){}
};

// Adaptee - old / legacy interfaces
class OldPrinter{
    public:
        void oldPrinting(){
            cout<<"Printing in a old way"<<endl;
        }
};

// Printer Adapter
class PrinterAdapter: public ModernPrinter{
    private:
        OldPrinter* oldPrinter;
    public:
        PrinterAdapter(OldPrinter* op): oldPrinter(op){}
        void printDocument() override{
            oldPrinter->oldPrinting(); // Delegate the call
        }
};

int main(){
    OldPrinter* oldPrinter = new OldPrinter();
    PrinterAdapter* adapter = new PrinterAdapter(oldPrinter);

    adapter->printDocument();

    delete oldPrinter;
    delete adapter;
    return 0;
}