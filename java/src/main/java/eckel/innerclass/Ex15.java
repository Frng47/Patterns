package eckel.innerclass;

public class Ex15 {
    static Ex15Second retSec(){
        return new Ex15Second();
    }

    public static void main(String[] args) {
        Ex15Second secondInh=retSec();
        };
    }


class Ex15Second{
    static int i=5;
    Ex15Second(){};
    Ex15Second(int i){};

}
