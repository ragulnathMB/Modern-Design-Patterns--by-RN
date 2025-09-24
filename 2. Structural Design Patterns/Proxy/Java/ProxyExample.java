// Proxy Pattern Example in Java
// Image viewer with lazy-loading proxy

interface Image { void display(); }

class RealImage implements Image {
    private final String filename;
    RealImage(String filename){ this.filename = filename; loadFromDisk(); }
    private void loadFromDisk(){ System.out.println("Loading image: " + filename); }
    public void display(){ System.out.println("Displaying: " + filename); }
}

class ProxyImage implements Image {
    private final String filename;
    private RealImage real;
    ProxyImage(String filename){ this.filename = filename; }
    public void display(){ if (real == null) real = new RealImage(filename); real.display(); }
}

public class ProxyExample {
    public static void main(String[] args){ Image img = new ProxyImage("photo.jpg"); img.display(); img.display(); }
}
