package eckel.io;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSON {
    public static void writeJsonSimpleDemo(String filename) throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", "Stackabuser");
        sampleObject.put("age", 35);

        JSONArray messages = new JSONArray();
        messages.add("Hey!");
        messages.add("What's up?!");

        sampleObject.put("messages", messages);
        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
    }
    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
    public static void main(String[] args) throws Exception {
        String path="D:\\dev\\files\\Person.json";
        writeJsonSimpleDemo(path);
        System.out.println(readJsonSimpleDemo(path).toString());
    }
}
class Person {
    Person(String name, int age, boolean isMarried, List<String> hobbies,
           List<Person> kids) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.hobbies = hobbies;
        this.kids = kids;
    }

    Person(String name, int age) {
        this(name, age, false, null, null);
    }

    private String name;
    private Integer age;
    private Boolean isMarried;
    private List<String> hobbies;
    private List<Person> kids;

    // getters and setters

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", hobbies=" + hobbies +
                ", kids=" + kids +
                '}';
    }
}