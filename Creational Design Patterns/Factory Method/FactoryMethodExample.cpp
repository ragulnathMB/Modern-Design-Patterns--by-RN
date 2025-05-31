#include<bits/stdc++.h>
using namespace std;

// Document Interface
class Document{
    public:
        virtual void use()=0;
        virtual ~Document(){};
};

// Concrete Document Classes
class PDFDocument: public Document{
    public:
        void use() override{
            cout<<"You are using a PDF Document"<<endl;
        }
};
class WordDocument: public Document{
    public:
        void use() override{
            cout<<"You are using a Word Document"<<endl;
        }
};

// Creator Interface
class DocumentCreator{
    public:
        virtual Document* createDocument()=0;
        virtual ~DocumentCreator(){};
};

// Concrete Creator Classes
class PDFCreator: public DocumentCreator{
    public:
        Document* createDocument() override{
            return new PDFDocument();
        }
};
class WordCreator: public DocumentCreator{
    public:
        Document* createDocument() override{
            return new WordDocument();
        }
};



int main(){
    DocumentCreator* creator;
    creator=new PDFCreator();
    Document* document1=creator->createDocument();
    document1->use();

    creator=new WordCreator();
    Document*document2=creator->createDocument();
    document2->use();

    delete creator;
    delete document1;
    delete document2;

    return 0;
}