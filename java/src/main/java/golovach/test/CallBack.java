package golovach.test;

public class CallBack {
    CallBack callBack;
    void register(CallBack callBack){
        this.callBack=callBack;
    }
    public static void main(String[] args) {
    this.register(new CallBack(){
        
    });
    }

}
interface Callback{
    void execute();
}