package golovach.io.filters.procedural;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ZeroByteFilter {
    enum States{
        ZERO_STATE,NUMBER_STATE;
    }
    static void filter(InputStream in, OutputStream out, int buffSize) throws IOException {
        byte[] buff=new byte[buffSize];
        boolean state=false,prevState,pFront,nFront;
        int startNumber=0;
        int count=0;

        while ((count=in.read(buff))!=-1){
            for(int i=0;i<count;i++){
                prevState=state;
                state=((buff[i])==0)?false:true;
                nFront=(state!=prevState&&prevState==true)?true:false;
                pFront=(state!=prevState&&prevState==false)?true:false;

                if(pFront)
                    startNumber=i;
                else if(nFront)
                     out.write(buff,startNumber,i);
                else if(i==(buffSize-1)&&state==true)
                    out.write(buff,startNumber,buffSize-1);
            }
        }

    }
    //Final state Automata
    static  void filterFSA(InputStream in, OutputStream out, int buffSize) throws IOException{
        States state=States.ZERO_STATE
                ,prevState=States.ZERO_STATE;
        int count;

        int startCopyNumber=0;
        byte[] buff=new byte[buffSize];
        while ((count=in.read(buff))!=-1){
            for (int i = 0; i <count ; i++) {
                state=(in.read()==0)?States.ZERO_STATE:States.NUMBER_STATE;
                switch (state){
                    case ZERO_STATE:
                        if(prevState==States.NUMBER_STATE)
                            out.write(buff,startCopyNumber,i);
                    case NUMBER_STATE:
                        if(prevState==States.ZERO_STATE)
                            startCopyNumber=i;
            }
          }
            if(state==States.NUMBER_STATE)
                out.write(buff,startCopyNumber,buffSize);
        }

    }
}

