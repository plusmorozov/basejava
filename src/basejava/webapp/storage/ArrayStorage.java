package basejava.webapp.storage;

import basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int countResume;

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Резюме с id = " + r.getUuid() + " уже существует");
        } else if (countResume == storage.length) {
            System.out.println("Сохранить резюме невозможно. Нет места");
        } else {
            storage[countResume] = r;
            countResume++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме с id = " + uuid + " не существует");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[getIndex(uuid)] = storage[countResume - 1];
            storage[countResume - 1] = null;
            countResume--;
        } else {
            System.out.println("Резюме с id = " + uuid + " не существует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
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
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}