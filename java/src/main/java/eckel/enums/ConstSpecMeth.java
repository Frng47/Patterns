package eckel.enums;

import java.text.DateFormat;
import java.util.Date;

public enum ConstSpecMeth {
    DATE_TIME {
        String getInfo() {
            return
                    DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();
    public static void main(String[] args) {
        for(ConstSpecMeth csm : values())
            System.out.println(csm.getInfo());
    }
} /* (Execute to see output) *///:~

