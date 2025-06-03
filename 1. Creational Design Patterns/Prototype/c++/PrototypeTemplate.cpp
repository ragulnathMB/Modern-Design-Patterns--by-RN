#include<bits/stdc++.h>
using namespace std;

// Create a Abstract Prototype;
class Enemy{
    public:
        virtual Enemy* clone()=0;
        virtual void attack()=0;
        virtual ~Enemy(){}
};

// Create Concrete Enemy classes
class Orc : public Enemy{
    private:
        int strength;
    public:
        Orc(int val):strength(val){}
        Enemy* clone() override {
            return new Orc(*this);
        }
        void attack(){
            cout<<"Orc with strength : "<<strength<<" has attacked."<<endl;
        }
};
class Goblin : public Enemy{
    private:
        int speed;
    public:
        Goblin(int val):speed(val){}
        Enemy* clone() override{
            return new Goblin(*this);
        }
        void attack(){
            cout<<"Goblin with speed : "<<speed<<" has attacked."<<endl;
        }
};

// Enemy Registry
class EnemyRegistry{
    private:
        map<string,Enemy*>registry;
    public:
        void registerEnemy(string enemyName,Enemy*enemy){
            registry[enemyName]=enemy;
        }
        Enemy* getClone(string enemyName){
            return registry[enemyName]->clone();
        }
};

int main(){
    EnemyRegistry* registry=new EnemyRegistry();
    // Register enemies
    registry->registerEnemy("Goblin",new Goblin(60));
    registry->registerEnemy("Orc",new Orc(100));

    Enemy* enemy1=registry->getClone("Goblin");
    Enemy* enemy2 = registry->getClone("Orc");

    enemy1->attack();
    enemy2->attack();

    delete registry;
    delete enemy1;
    delete enemy2;
    return 0;
}
