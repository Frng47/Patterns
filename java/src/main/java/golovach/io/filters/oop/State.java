package golovach.io.filters.oop;

import java.io.IOException;
import java.io.OutputStream;

abstract class State{
    protected final OutputStream out;
    public static int startPoint=0;
    public static int counter=0;
    public static byte[] bytes;

    protected State(OutputStream out) {
        this.out = out;
    }
    public State(OutputStream out,byte[] buff) {
        this.out = out;
        bytes=buff;
    }

    public abstract State next(byte value) throws IOException;//return next state
    public void finish() throws IOException {
        bytes=null;
        counter=0;
    };
}
