import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class TestArgumentcaptor1 {
    @Mock Doc1 doc;
    @InjectMocks VerifyEx1 ex;
    @Captor ArgumentCaptor<String> captor;

    @Test
    public void testIndirectOutput() {
        initMocks(this);
        ex.foo("Hello World", 2);
        verify(doc, times(2)).send(captor.capture());
        assertEquals("Hello World1", captor.getAllValues().get(0));
        assertEquals("Hello World2", captor.getAllValues().get(1));
    }
}
