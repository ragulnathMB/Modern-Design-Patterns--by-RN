#include <iostream>
#include <unordered_map>
#include <memory>
using namespace std;

// Flyweight class: shared font properties
class Font {
private:
    string fontFamily;
    int fontSize;
public:
    Font(const string& family, int size) : fontFamily(family), fontSize(size) {}

    void display(const string& character, int position) {
        cout << "Character '" << character 
             << "' with font [" << fontFamily << ", " << fontSize 
             << "] at position " << position << endl;
    }
};

// Factory to manage font objects
class FontFactory {
private:
    unordered_map<string, shared_ptr<Font>> fontPool;

    string getKey(const string& family, int size) {
        return family + ":" + to_string(size);
    }

public:
    shared_ptr<Font> getFont(const string& family, int size) {
        string key = getKey(family, size);
        if (fontPool.find(key) == fontPool.end()) {
            fontPool[key] = make_shared<Font>(family, size);
            cout << "Creating new Font: " << key << endl;
        }
        return fontPool[key];
    }

    void listFonts() {
        cout << "\nTotal unique fonts used: " << fontPool.size() << endl;
        for (auto& pair : fontPool) {
            cout << " - " << pair.first << endl;
        }
    }
};

int main() {
    FontFactory factory;

    auto font1 = factory.getFont("Arial", 12);
    auto font2 = factory.getFont("Arial", 12);
    auto font3 = factory.getFont("Times New Roman", 14);

    font1->display("A", 1);
    font2->display("B", 2);
    font3->display("C", 3);

    factory.listFonts();

    return 0;
}
