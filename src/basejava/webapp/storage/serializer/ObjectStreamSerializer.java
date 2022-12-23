package basejava.webapp.storage.serializer;

import basejava.webapp.exception.StorageException;
import basejava.webapp.model.Resume;
import basejava.webapp.storage.serializer.StrategySerialize;

import java.io.*;

public class ObjectStreamSerializer implements StrategySerialize {
    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}
