public class TempController {
    private ControllerState state;

    public TempController() {
        state = ControllerState.IDLE;
    }

    void powerOn() {
        System.out.println("poweron");
    }

    void powerOff() {
        System.out.println("poweroff");
    }

    public void start() {
        if (state == ControllerState.IDLE) {
            powerOn();
            state = ControllerState.OPERATING;
        }
    }

    public void stop() {
        if (state == ControllerState.OPERATING) {
            powerOff();
            state = ControllerState.IDLE;
        }
    }

    public void high() {
        if (state == ControllerState.OPERATING) {
            activateCooler();
            state = ControllerState.COOLING;
        }
    }

    void activateCooler() {
    }

    public void low() {
        if (state == ControllerState.OPERATING) {
            activateHeater();
            state = ControllerState.HEATING;
        }
    }

    void activateHeater() {
    }

    public void inRange() {
        if (state == ControllerState.COOLING) {
            deactivateCooler();
            state = ControllerState.OPERATING;
        }
        if (state == ControllerState.HEATING) {
            deactivateHeater();
            state = ControllerState.OPERATING;
        }
    }

    public void setState(ControllerState state) {
        this.state = state;
    }

    public ControllerState getState() {
        return this.state;
    }

    private void deactivateHeater() {
    }

    void deactivateCooler() {
    }

}
