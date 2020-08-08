package golovach.io.filters.oop;

import java.io.IOException;
import java.io.OutputStream;

class Numbers extends State{

    protected Numbers(OutputStream out) {
        super(out);
    }

    @Override
    public State next(byte value) throws IOException {
        if(value==0){
            out.write(State.bytes,startPoint,counter-startPoint);
            counter++;
            return new Zero(out);
        }else {
            counter++;
            return new Numbers(out);
        }
    }

    @Override
    public void finish() throws IOException {
        out.write(State.bytes,startPoint,counter-startPoint);
        bytes=null;
        counter=0;
    }
}
