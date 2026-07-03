import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DataProcessorTest {
    @Test
    public void testMultipleReturns() {
        DataFetcher mockFetcher = Mockito.mock(DataFetcher.class);
        when(mockFetcher.fetch())
            .thenReturn("First")
            .thenReturn("Second");
        DataProcessor processor = new DataProcessor(mockFetcher);
        String result = processor.processTwice();
        assertEquals("First and Second", result);
    }
}
