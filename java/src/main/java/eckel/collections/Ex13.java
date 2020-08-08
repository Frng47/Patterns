package eckel.collections;



import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Ex13 {

}
class Controller {
    // A class from java.util to hold Event objects:
    private List<Event> eventList = new LinkedList<Event>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
// Make a copy so you’re not modifying the list
// while you’re selecting the elements in it:
            /*for (Event e : new LinkedList<Event>(eventList))
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }*/
            ListIterator<Event> it=eventList.listIterator();
            if (it.next().ready()) {
                System.out.println(it.next());
                it.next().action();
                it.remove();
            }
        }
    }
}
abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() { // Allows restarting
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
} ///:~


