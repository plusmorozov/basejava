package basejava.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Резюме с id = " + uuid + " не существует", uuid);
    }
}
