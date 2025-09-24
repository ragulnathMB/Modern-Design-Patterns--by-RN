// Singleton Pattern – Java Template
// Static holder idiom for thread-safe lazy init

class Singleton {
    private Singleton() {}
    private static class Holder { private static final Singleton INSTANCE = new Singleton(); }
    public static Singleton getInstance() { return Holder.INSTANCE; }
}

public class SingletonTemplate {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }
}
