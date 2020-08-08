/**
 * Exercise 11: (2) In the innerclasses/GreenhouseController.java example,
 * GreenhouseController contains a hard-coded set of events. Change the program so that it
 * reads the events and their relative times from a text file, ((difficulty level 8): Use a Factory
 * Method design pattern to build the events—see Thinking in Patterns (with Java) at
 * www.MindView.net.)
 */
package eckel.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Ex11 extends Controller {
    private boolean light=false;
    private boolean water=false;
    private boolean vent=false;
    public class LightOn extends Event{
        public LightOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            light=true;
        }
    }
    public class LightOff extends Event{
        public LightOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            light=false;
        }
    }
    public class VentOn extends Event{
        public VentOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            vent=true;
        }
    }
    public class VentOff extends Event{
        public VentOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            vent=false;
        }
    }
    public class WaterOn extends Event{
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            water=true;
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            water=false;
        }
    }
    Map<String, Long> loadSchedule(String path){
        String s;
        Map<String,Long> map=new HashMap<>();
        try{
        BufferedReader in=new BufferedReader(new FileReader(path));
        try{
            while ((s=in.readLine())!=null){
                String[] arr=s.split(" ");
                map.put(arr[0],new Long(arr[1]));
            }
        }finally {
            in.close();
        }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return map;
    }
    void fillEventList(Map<String,Long> map){
        for(Map.Entry<String,Long> me:map.entrySet()){
            String key=me.getKey();
            Long value=me.getValue();
            if(key.equalsIgnoreCase("LightOn"))
                addEvent(new CreateLightOn().factoryMethod(me.getValue()));
            if(key.equalsIgnoreCase("LightOff"))
                addEvent(new CreateLightOff().factoryMethod(me.getValue()));
            if(key.equalsIgnoreCase("WaterOn"))
                addEvent(new CreateWaterOn().factoryMethod(me.getValue()));
            if(key.equalsIgnoreCase("WaterOff"))
                addEvent(new CreateWaterOff().factoryMethod(me.getValue()));
            if(key.equalsIgnoreCase("VentOn"))
                addEvent(new CreateVentOn().factoryMethod(me.getValue()));
            if(key.equalsIgnoreCase("VentOff"))
                addEvent(new CreateVentOff().factoryMethod(me.getValue()));
        }
        map.clear();
    }
//****************************************************************
    public static void main(String[] args) {
        Ex11 controller=new Ex11();
        controller.fillEventList(controller.loadSchedule("c:\\users\\m.gladikov\\desktop\\files\\controller.txt"));
        controller.run();
    }
//****************************************************************
    class CreateLightOn extends Creator{
        public  Event factoryMethod(long delayTime) {
            return new Ex11.LightOn(delayTime);
        }
    }
    class CreateLightOff extends Creator{
        public  Event factoryMethod(long delayTime) {
            return new Ex11.LightOff(delayTime);
        }
    }
    class CreateWaterOn extends Creator{
        public  Event factoryMethod(long delayTime) {
            return new Ex11.WaterOn(delayTime);
        }
    }
    class CreateWaterOff extends Creator{
        public  Event factoryMethod(long delayTime) {
            return new Ex11.WaterOff(delayTime);
        }
    }
    class CreateVentOn extends Creator{
        public  Event factoryMethod(long delayTime) {
            return new Ex11.VentOn(delayTime);
        }
    }
    class CreateVentOff extends Creator{
        public  Event factoryMethod(long delayTime) {
            return new Ex11.VentOff(delayTime);
        }
    }
}
abstract class Event{
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime=delayTime;
        start();
    }
    public void start(){eventTime=System.nanoTime()+delayTime;}
    public boolean ready(){return System.nanoTime()>=eventTime;}
    abstract public void action();
}
class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event event) {
        eventList.add(event);
    }
    public void run() {
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
abstract class Creator{
    public abstract Event factoryMethod(long delayTime);
}

