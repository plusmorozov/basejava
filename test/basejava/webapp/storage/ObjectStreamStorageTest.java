package basejava.webapp.storage;

import basejava.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}