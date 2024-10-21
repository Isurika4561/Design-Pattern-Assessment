public class Singleton {
    private static Singleton instance; // Single instance of the class

    private Singleton() {} // Private constructor to prevent external instantiation

    public static Singleton getInstance() {
        if (instance == null) {
            // Thread-safe approach (can be simplified if thread safety isn't critical)
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Since it's a singleton, singleton1 and singleton2 refer to the same object
        if (singleton1 == singleton2) {
            System.out.println("It's the same instance!");
        }
    }
}
