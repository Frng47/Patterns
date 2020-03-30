package patterns.creational.abstractFactory;

// an existing hierarchy
interface Button {
    void paint();
}
class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}
class OSXButton implements Button {
    @Override
    public void paint() {
        System.out.println("OSXButton");
    }
}

public class AbstractFactoryEngWiki {
    // abstract the way to create a button
    @FunctionalInterface
    interface GUIFactory {
        public Button createButton();
    }

    static class WinFactory implements GUIFactory {
        public Button createButton() {
            return new WinButton();
        }
    }

    static class OSXFactory implements GUIFactory {
        public Button createButton() {
            return new OSXButton ();
        }
    }

    private static GUIFactory factory(String appearance) {
        switch(appearance) {
            case "osx":
                return new OSXFactory();
            case "win":
                return new WinFactory();
            default:
                throw new IllegalArgumentException("unknown " + appearance);
        }
    }

    public static void main(final String[] arguments) {
     //   Button button=this.GUIFactory("osx");
    }
}