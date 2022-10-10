package basejava.webapp.storage;

import basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int cntResume;

    public void clear() {
        Arrays.fill(storage, 0, cntResume, null);
        cntResume = 0;
    }

    public void save(Resume r) {
        if (get(r.getUuid()) != null) {
            System.out.println("Резюме с id = " + r.getUuid() + " уже существует");
        } else if (cntResume == storage.length) {
            System.out.println("Сохранить резюме невозможно. Нет места");
        } else {
            storage[cntResume] = r;
            cntResume++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Резюме с id = " + uuid + " не существует");
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[getIndex(uuid)] = storage[cntResume - 1];
            storage[cntResume - 1] = null;
            cntResume--;
        } else {
            System.out.println("Резюме с id = " + uuid + " не существует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, cntResume);
    }

    public int size() {
        return cntResume;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
            System.out.println("Резюме с id = " + r.getUuid() + " обновлено");
        } else {
            System.out.println("Резюме с id = " + r.getUuid() + " не существует");
        }
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < cntResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}