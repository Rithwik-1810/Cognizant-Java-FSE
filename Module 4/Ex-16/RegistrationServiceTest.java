import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class RegistrationServiceTest {
    @Test
    public void testVoidMethodWithException() {
        Validator mockValidator = Mockito.mock(Validator.class);
        doThrow(new IllegalArgumentException("Invalid input")).when(mockValidator).validate("invalid");
        RegistrationService service = new RegistrationService(mockValidator);
        assertThrows(IllegalArgumentException.class, () -> {
            service.register("invalid");
        });
    }
}
