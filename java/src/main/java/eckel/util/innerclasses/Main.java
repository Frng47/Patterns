package eckel.util.innerclasses;


class Main {
    public static void main(String[] args) {
        ControllerGreenHouse gc = new ControllerGreenHouse();
// Instead of hard-wiring, you could parse
// configuration information from a text file here:
                gc.addEvent(gc.new Bell(900000));
        Event[] eventListGreen = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200000),
                gc.new LightOff(400000),
                gc.new WaterOn(600000),
                gc.new WaterOff(800000),
                gc.new fanOn(900000),
                gc.new fanOff(950000),
                gc.new ThermostatDay(1400000)
        };
        gc.addEvent(gc.new Restart(2000000, eventListGreen));
        if (args.length == 1)
            gc.addEvent(
                    new ControllerGreenHouse.Terminate(
                            new Integer(args[0])));
        gc.run();
    }
}