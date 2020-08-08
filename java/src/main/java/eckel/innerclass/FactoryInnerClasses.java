package eckel.innerclass;

public class FactoryInnerClasses {
    public static void getService(){
        ServiceImpl.factory.createService().method();
    }
    public static void main(String[] args) {
    getService();
    }
}
interface Service{
    void method();
}
interface Factory{
    Service createService();
}
class ServiceImpl implements Service {
    ServiceImpl(){};
    public void method() {
        System.out.println("service has been provided");
    }
    public static Factory factory=new Factory() {
        public Service createService() {
            return new ServiceImpl();
        }
    };
}

