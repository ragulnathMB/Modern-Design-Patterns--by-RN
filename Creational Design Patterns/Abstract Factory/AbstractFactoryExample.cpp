#include<bits/stdc++.h>
using namespace std;

// Abstract GUI components
class AbstractButton{
    public:
        virtual void renderButton()=0;
        virtual ~AbstractButton(){}
};
class AbstractCheckbox{
    public:
        virtual void renderCheckBox()=0;
        virtual ~AbstractCheckbox(){}
};

// Abstract GUI Factory
class GUIFactory{
    public:
        virtual AbstractButton* createButton()=0;
        virtual AbstractCheckbox* createCheckBox()=0;
        virtual ~GUIFactory(){}
};

// Dark theme components
class DarkButton: public AbstractButton{
    public:
        void renderButton() override{
            cout<<"Rendering Dark Button"<<endl;
        }
};
class DarkCheckBox: public AbstractCheckbox{
    public:
        void renderCheckBox() override{
            cout<<"Rendering Dark Check Box"<<endl;
        }
};

// Light theme components
class LightButton: public AbstractButton{
    public:
        void renderButton() override{
            cout<<"Rendering Light Button"<<endl;
        }
};
class LightCheckBox: public AbstractCheckbox{
    public:
        void renderCheckBox() override{
            cout<<"Rendering Light Check Box"<<endl;
        }
};

// Dark GUI Factory
class DarkFactory: public GUIFactory{
    public:
        AbstractButton* createButton() override{
            return new DarkButton();
        }
        AbstractCheckbox* createCheckBox() override{
            return new DarkCheckBox();
        }
};

// Light GUI Factory
class LightFactory: public GUIFactory{
    public:
        AbstractButton* createButton() override{
            return new LightButton();
        }
        AbstractCheckbox* createCheckBox() override{
            return new LightCheckBox();
        }
};

int main(){
    // Renders Light components
    GUIFactory* factory=new LightFactory();
    AbstractButton* button=factory->createButton();
    AbstractCheckbox* checkBox=factory->createCheckBox();
    button->renderButton();
    checkBox->renderCheckBox();

    delete factory;
    delete button;
    delete checkBox;
    
    // Renders Dark components
    factory= new DarkFactory();
    button=factory->createButton();
    checkBox= factory->createCheckBox();
    button->renderButton();
    checkBox->renderCheckBox();

    delete factory;
    delete button;
    delete checkBox;


    return 0;
}
