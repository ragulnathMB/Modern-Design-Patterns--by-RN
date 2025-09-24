// Singleton Pattern Example in Java
// Thread-safe initialization via static holder idiom

class AppConfig {
    private AppConfig() {}
    private String connectionString = "jdbc:mysql://localhost:3306/app";

    private static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    public void print() {
        System.out.println("Connection: " + connectionString);
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();
        System.out.println(a == b); // true
        a.print();
    }
}
