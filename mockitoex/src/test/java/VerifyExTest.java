import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class VerifyExTest {
    @Mock
    Doc b;
    @InjectMocks
    VerifyEx doc;

    @Test
    public void testIndirectOutput() {
//        VerifyEx a = new VerifyEx();
//        IDoc doc = mock(IDoc.class);
//        a.setDoc(doc);

        initMocks(this);
        doc.doIt("Hello");
        verify(b, times(2)).say("Hello World1!");
    }

    @Test
    public void testIndirectOutput1() {
//        VerifyEx a = new VerifyEx();
//      IDoc doc = mock(IDoc.class);
//        a.setDoc(doc);

        initMocks(this);
        doc.doIt("Hello1");
        verify(b, times(1)).say("Good Bye!");
    }
}
