package by.gsu.pms;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class Session implements AutoCloseable {
    public Session(
        String managerFileName
    ) throws IOException, ClassNotFoundException {
        _managerFileName = managerFileName;
    }

    private final String _managerFileName;
    private final ArrayList<Manager> _managers = new ArrayList<>();
    private boolean _closed = false;

    public void run() {

    }

    @Override
    public void close() throws IOException {
        if (!_closed) {
            _closed = true;
        }
    }

    private void printManagers() {
        for (var manager : _managers) {
            System.out.println(
                MessageFormat.format(
                    "Manager {0} is {1} years old and is {2}",
                    manager.getSurname(),
                    manager.getAge(),
                    manager.isCompetent() ? "competent" : "incompetent"));
        }
    }

    private void throwIfClosed() {
        if (_closed) {
            throw new IllegalStateException("Session has been closed");
        }
    }
}
