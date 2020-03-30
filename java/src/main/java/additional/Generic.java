package additional;

public class Generic {

    //Holder<String> stringHolder=new Holder<>();
    //Holder<Double> doubleHolder=new Holder<>();
    
}
class GenericHolder<T>{
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}

