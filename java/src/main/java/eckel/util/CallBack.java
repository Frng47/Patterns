package eckel.util;

public class CallBack {
    public static void main(String[] args) {
         DoSomething exmpl=new DoSomething();
         exmpl.registerCallBack(new CallBackClass());
         exmpl.doSomething();
    }
}

class DoSomething{
    interface CallBackInt{
        void callingBack();
    }
    CallBackInt callBack;
    void registerCallBack(CallBackInt callBack){
        this.callBack=callBack;
    }

    void doSomething(){
        callBack.callingBack();
    }
}
class CallBackClass implements DoSomething.CallBackInt {
    @Override
    public void callingBack() {
        System.out.println("Call Back execute");
    }
}