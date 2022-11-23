package basejava.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorage.class,
                ListStorageTest.class,
                MapUuidStorageTest.class,
        }
)

public class AllStorageTest {

}
