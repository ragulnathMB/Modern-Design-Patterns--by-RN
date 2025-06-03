#include <iostream>
using namespace std;

// Subsystem: DVD Player
class DVDPlayer {
public:
    void on() { cout << "DVD Player is ON\n"; }
    void play() { cout << "DVD is Playing\n"; }
    void off() { cout << "DVD Player is OFF\n"; }
};

// Subsystem: Projector
class Projector {
public:
    void on() { cout << "Projector is ON\n"; }
    void setInput() { cout << "Projector input set to DVD\n"; }
    void off() { cout << "Projector is OFF\n"; }
};

// Subsystem: Sound System
class SoundSystem {
public:
    void on() { cout << "Sound System is ON\n"; }
    void setVolume(int level) { cout << "Sound volume set to " << level << endl; }
    void off() { cout << "Sound System is OFF\n"; }
};

// Facade: Home Theater
class HomeTheaterFacade {
private:
    DVDPlayer dvd;
    Projector projector;
    SoundSystem sound;
public:
    void watchMovie() {
        cout << "\n--- Starting Movie ---\n";
        dvd.on();
        projector.on();
        projector.setInput();
        sound.on();
        sound.setVolume(8);
        dvd.play();
    }

    void endMovie() {
        cout << "\n--- Stopping Movie ---\n";
        dvd.off();
        projector.off();
        sound.off();
    }
};

int main() {
    HomeTheaterFacade theater;
    theater.watchMovie();
    theater.endMovie();
    return 0;
}
