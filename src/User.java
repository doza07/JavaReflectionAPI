import java.io.Serializable;


public class User extends Person implements Serializable, Comparable<User> {


    private String name;

    @MinAge(21)
    private Integer age;

    public User(Long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
