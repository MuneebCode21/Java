final class Logger {
    private static Logger instance;
    private int logCount;

    private Logger() {
        logCount = 0;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // only once
        }
        return instance;
    }

    public final void log(String message) {
        logCount++;
        System.out.println("[" + logCount + "] " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();

        int i = 0;
        while (i < 3) {
            log.log("Operation " + (i + 1) + " completed.");
            i++;
        }

        Logger anotherLog = Logger.getInstance(); // same instance
        anotherLog.log("Final operation.");
    }
}
