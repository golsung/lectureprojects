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
    @Mock Doc b;
    @InjectMocks VerifyEx a;
    @Captor ArgumentCaptor<String> captor;

    @Test
    public void testIndirectOutput() {
        initMocks(this);
        a.doIt("Hello");
        verify(b, times(2)).say(captor.capture());
        assertEquals("Hello World!", captor.getAllValues().get(0));
        assertEquals("Hello World!", captor.getAllValues().get(1));
    }
}
