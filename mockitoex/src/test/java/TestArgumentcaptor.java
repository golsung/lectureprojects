import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class TestArgumentcaptor {
    @Mock Doc doc;
    @InjectMocks VerifyEx ex;
    @Captor ArgumentCaptor<String> captor;

    @Test
    public void testIndirectOutput() {
        initMocks(this);
        ex.doIt("Hello");
        verify(doc, times(2)).say(captor.capture());
        assertEquals("Hello World1!", captor.getAllValues().get(0));
        assertEquals("Hello World2!", captor.getAllValues().get(1));
    }
}
