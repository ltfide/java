package dev.local;

public class UserService {

    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(String user) {
        threadLocal.set(user);
    }

    public void doAction() {
        String user = threadLocal.get();
        System.out.println("User: " + user);
    }
}
