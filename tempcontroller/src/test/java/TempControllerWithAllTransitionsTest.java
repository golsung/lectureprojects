import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

@DisplayName("All Transitions 테스팅")
@ExtendWith(MockitoExtension.class)
class TempControllerWithAllTransitionsTest {
    @DisplayName("For invalid transitions")
    @Nested
    class WhenInvalidTransitionHappens {
        @DisplayName("Idle->stop->Idle")
        @Test
        void should_BeInIdle_ForStopEventWhenInIdle() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.stop();
            assertEquals(ControllerState.IDLE, spyCont.getState());
        }

        @DisplayName("Idle->high->Idle")
        @Test
        void should_BeInIdle_ForHighEventWhenInIdle() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.high();
            assertEquals(ControllerState.IDLE, spyCont.getState());
        }

        @DisplayName("Idle->inRange->Idle")
        @Test
        void should_BeInIdle_ForInRangeEventWhenInIdle() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.inRange();
            assertEquals(ControllerState.IDLE, spyCont.getState());
        }

        @DisplayName("Idle->low->Idle")
        @Test
        void should_BeInIdle_ForLowEventWhenInIdle() {
            TempController cont = new TempController(); TempController spyCont = spy(cont);
            spyCont.low();
            assertEquals(ControllerState.IDLE, spyCont.getState());
        }

        @DisplayName("Operating->start->Operating")
        @Test
        void should_BeInOperating_ForStartEventWhenInOperating() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.OPERATING);
            spyCont.start();
            assertEquals(ControllerState.OPERATING, spyCont.getState());
        }
        @DisplayName("Operating->inRange->Operating")
        @Test
        void should_BeInOperating_ForInRangeEventWhenInOperating() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.OPERATING);
            spyCont.inRange();
            assertEquals(ControllerState.OPERATING, spyCont.getState());
        }
        @DisplayName("Heating->start->Heating")
        @Test
        void should_BeInHeating_ForStartEventWhenInHeating() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.HEATING);
            spyCont.start();
            assertEquals(ControllerState.HEATING, spyCont.getState());
        }
        @DisplayName("Heating->stop->Heating")
        @Test
        void should_BeInHeating_ForStopEventWhenInHeating() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.HEATING);
            spyCont.stop();
            assertEquals(ControllerState.HEATING, spyCont.getState());
        }
        @DisplayName("Heating->low->Heating")
        @Test
        void should_BeInHeating_ForLowEventWhenInHeating() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.HEATING);
            spyCont.low();
            assertEquals(ControllerState.HEATING, spyCont.getState());
        }
        @DisplayName("Cooling->start->Cooling")
        @Test
        void should_BeInCooling_ForStartEventWhenInCooling() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.COOLING);
            spyCont.start();
            assertEquals(ControllerState.COOLING, spyCont.getState());
        }
        @DisplayName("Cooling->stop->Cooling")
        @Test
        void should_BeInCooling_ForStopEventWhenInCooling() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.COOLING);
            spyCont.stop();
            assertEquals(ControllerState.COOLING, spyCont.getState());
        }
        @DisplayName("Cooling->high->Cooling")
        @Test
        void should_BeInCooling_ForHighEventWhenInCooling() {
            TempController cont = new TempController();
            TempController spyCont = spy(cont);
            spyCont.setState(ControllerState.COOLING);
            spyCont.high();
            assertEquals(ControllerState.COOLING, spyCont.getState());
        }
    }
}
