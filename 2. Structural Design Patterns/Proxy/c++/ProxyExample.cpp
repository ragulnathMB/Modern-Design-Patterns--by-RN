#include <iostream>
#include <string>
using namespace std;

// Subject interface
class Image {
public:
    virtual void display() = 0;
    virtual ~Image() {}
};

// Real Subject
class RealImage : public Image {
private:
    string filename;

    void loadFromDisk() {
        cout << "Loading image from disk: " << filename << endl;
    }

public:
    RealImage(const string& file) : filename(file) {
        loadFromDisk();
    }

    void display() override {
        cout << "Displaying image: " << filename << endl;
    }
};

// Proxy
class ProxyImage : public Image {
private:
    string filename;
    RealImage* realImage;

public:
    ProxyImage(const string& file) : filename(file), realImage(nullptr) {}

    ~ProxyImage() {
        delete realImage;
    }

    void display() override {
        if (!realImage) {
            realImage = new RealImage(filename); // Lazy loading
        }
        realImage->display();
    }
};
int main() {
    Image* image = new ProxyImage("high_res_photo.png");

    cout << "Image created, but not loaded yet.\n";

    cout << "\nFirst display call:\n";
    image->display();  // Will load from disk and display

    cout << "\nSecond display call:\n";
    image->display();  // Will just display (no reloading)

    delete image;
    return 0;
}
