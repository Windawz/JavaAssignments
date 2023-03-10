package by.gsu.pms;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

public class ManagerDeserializer implements AutoCloseable {
    public ManagerDeserializer(String fileName) throws IOException {
        _stream = new ObjectInputStream(
            new FileInputStream(fileName));
    }

    private ObjectInputStream _stream;

    public Optional<Manager> deserializeNext() throws IOException, ClassNotFoundException {
        throwIfClosed();
        Object o;
        try {
            o = _stream.readObject();
        } catch (EOFException e) {
            return Optional.empty();
        }
        return Optional.of((Manager)o);
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
            throw new IllegalStateException("Deserializer has been closed");
        }
    }
}
