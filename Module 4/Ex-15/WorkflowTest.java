import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.inOrder;

public class WorkflowTest {
    @Test
    public void testInteractionOrder() {
        TaskRunner mockRunner = Mockito.mock(TaskRunner.class);
        Workflow workflow = new Workflow(mockRunner);
        workflow.execute();
        InOrder inOrder = inOrder(mockRunner);
        inOrder.verify(mockRunner).stepOne();
        inOrder.verify(mockRunner).stepTwo();
    }
}
