import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Alice");
        when(userRepository.findByName("Alice")).thenReturn(Arrays.asList(user1, user2));

        List<User> result = userRepository.findByName("Alice");
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }
}
