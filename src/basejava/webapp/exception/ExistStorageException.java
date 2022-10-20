package basejava.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Резюме с id = " + uuid + " уже существует", uuid);
    }
}
