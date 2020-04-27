/**
 * Create and test a SixTuple generic.
 */

package eckel.generics;

public class Ex3 {
}

class SixTuple<A, B, C, D, F, G> {
    public final A a;
    public final B b;
    public final C c;
    public final D d;
    public final F f;
    public final G g;

    public SixTuple(A a, B b, C c, D d, F f, G g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.g = g;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", f=" + f +
                ", g=" + g +
                '}';
    }
}
