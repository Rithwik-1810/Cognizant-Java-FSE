import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class DatabaseServiceTest {
    @Test
    public void testVoidMethod() {
        Database mockDb = Mockito.mock(Database.class);
        doNothing().when(mockDb).save("test-data");
        DatabaseService service = new DatabaseService(mockDb);
        service.persist("test-data");
        verify(mockDb).save("test-data");
    }
}
