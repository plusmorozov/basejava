package basejava.webapp;

import basejava.webapp.model.Resume;
import basejava.webapp.storage.ArrayStorage;
import basejava.webapp.storage.Storage;

/**
 * Test for your basejava.webapp.storage.ArrayStorage implementation
 * add branch HW3
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "Name1");
        final Resume r2 = new Resume("uuid2", "Name2");
        final Resume r3 = new Resume("uuid3", "Name3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Вывод проверок");
        ARRAY_STORAGE.get("test");
        ARRAY_STORAGE.update(r1);
        ARRAY_STORAGE.delete("test");
        ARRAY_STORAGE.save(r1);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}