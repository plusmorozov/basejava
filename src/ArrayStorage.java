import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int cntResume;

    void clear() {
        Arrays.fill(storage, 0, cntResume, null);
        cntResume = 0;
    }

    void save(Resume r) {
        storage[cntResume] = r;
        cntResume++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < cntResume; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < cntResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1,storage, i, cntResume - i - 1);
                storage[cntResume] = null;
                cntResume--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, cntResume);
    }

    int size() {
        return cntResume;
    }
}
