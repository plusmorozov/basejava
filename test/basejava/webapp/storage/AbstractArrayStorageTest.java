package basejava.webapp.storage;

import basejava.webapp.exception.NotExistStorageException;
import org.junit.Test;

public class AbstractArrayStorageTest {
    private Storage storage;
    @Test
    public void size() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}