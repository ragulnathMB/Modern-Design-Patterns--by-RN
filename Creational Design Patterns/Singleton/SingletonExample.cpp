#include<bits/stdc++.h>
using namespace std;


class Logger{
    private:
        static Logger* instance;
        Logger(){}
        time_t now = time(nullptr);
    
    public:
        Logger(const Logger&)=delete;
        Logger& operator=(const Logger&)=delete;

        static Logger* getInstance(){
            if(instance==nullptr){
                instance=new Logger();
            }
            return instance;
        }

        void Log(string message){
            
            cout<<"Message Logged : "<<message<<" at "<<ctime(&now)<<endl;
        }

};
Logger* Logger::instance=nullptr;

int main(){
    Logger* logger1=Logger::getInstance();
    logger1->Log("First Message");
    Logger* logger2=Logger::getInstance();
    logger2->Log("Second Message");
    return 0;
}