package by.gsu.pms;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var session = new Session()) {
            session.run();
        }
    }
}