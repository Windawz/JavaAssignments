package by.gsu.pms;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var session = new Session("managers.ser")) {
            session.run();
        }
    }
}