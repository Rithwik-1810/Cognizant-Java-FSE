import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class NotificationServiceTest {
    @Test
    public void testArgumentMatching() {
        ExternalService mockService = Mockito.mock(ExternalService.class);
        NotificationService service = new NotificationService(mockService);
        service.notifyUser("John");
        verify(mockService).send(eq("Hello John"), anyString());
    }
}
