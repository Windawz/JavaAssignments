package by.gsu.pms;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ManagerSerializer implements AutoCloseable {
    public ManagerSerializer(String fileName) throws IOException {
        _stream = new ObjectOutputStream(
            new FileOutputStream(fileName, false));
    }

    private ObjectOutputStream _stream;

    public void serialize(Manager manager) throws IOException {
        throwIfClosed();
        _stream.writeObject(manager);
    }

    @Override
    public void close() throws IOException {
        if (_stream != null) {
            _stream.close();
            _stream = null;
        }
    }

    private void throwIfClosed() {
        if (_stream == null) {
            throw new IllegalStateException("Serializer has been closed");
        }
    }
}
