import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@DisplayName("0-switch 테스팅")
@ExtendWith(MockitoExtension.class)
class TempControllerWithZeroSwitchTest {
    @DisplayName("Idle->Operating->Cooling->Operating->Heating")
    @Test
    void should_VisitAllValidTransitions() {
        TempController cont = new TempController();
        TempController spyCont = spy(cont);
        assertEquals(ControllerState.IDLE, spyCont.getState());
        spyCont.start();
        verify(spyCont).powerOn();
        assertEquals(ControllerState.OPERATING, spyCont.getState());
        spyCont.high(); verify(spyCont).activateCooler();
        assertEquals(ControllerState.COOLING, spyCont.getState());
        spyCont.inRange();
        verify(spyCont).deactivateCooler();
        assertEquals(ControllerState.OPERATING, spyCont.getState());
        spyCont.low();
        verify(spyCont).activateHeater();
        assertEquals(ControllerState.HEATING, spyCont.getState());
        spyCont.inRange();
        verify(spyCont).deactivateCooler();
        assertEquals(ControllerState.OPERATING, spyCont.getState());
        spyCont.stop();
        verify(spyCont).powerOff();
        assertEquals(ControllerState.IDLE, spyCont.getState());
    }

}
