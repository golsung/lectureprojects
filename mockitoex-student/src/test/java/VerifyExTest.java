import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class VerifyExTest {
    @Mock
    Doc b;
    @InjectMocks
    VerifyEx a;

    @Test
    public void testIndirectOutput() {
        initMocks(this);
        a.doIt("Hello");
        verify(b, times(2)).say("Hello World!");
    }
}
