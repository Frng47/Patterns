package golovach.io.filters.oop;

import java.io.IOException;
import java.io.OutputStream;

class Zero extends State{
    protected Zero(OutputStream out) {
        super(out);
    }
    protected Zero(OutputStream out,byte[] buff) {
        super(out,buff);
    }

    @Override
    public State next(byte value) throws IOException {
        if(value==0) {
            counter++;
            return new Zero(out);
        }else{
            State.startPoint=counter;
            counter++;
            return new Numbers(out);}
    }
}
