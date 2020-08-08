package eckel.io;
import javax.xml.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
//Convert Object to XML
public class XML {

    public static void main(String[] args) {


            Customer customer = new Customer();
            customer.setAge(55);
            customer.setId(1);
            customer.setName("Mario");

            try {

                File file = new File("D:\\dev\\files\\file.xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.marshal(customer, file);
                jaxbMarshaller.marshal(customer, System.out);

            } catch (JAXBException e) {
                e.printStackTrace();
            }

        }

}
@XmlRootElement
class Customer{
    @XmlAttribute
    private int Id;
    @XmlElement
    private int age;
    @XmlElement
    private String name;

    public void setId(int id) {
        Id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {

    }

    public Customer(int id, int age, String name) {
        Id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//Convert XML to Object
class JAXBExample {
    public static void main(String[] args) {

        try {

            File file = new File("d:\\dev\\files\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}