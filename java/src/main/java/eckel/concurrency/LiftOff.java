package eckel.concurrency;

import java.util.concurrent.Callable;

public class LiftOff implements Callable<Integer> {
    private int countDown=10;
    public LiftOff(){};
    public LiftOff(int countDown){
        this.countDown=countDown;
    };
    public Integer call() throws Exception {
        return null;
    }

}
