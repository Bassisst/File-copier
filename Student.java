package wins;

public class Student {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private int id;

 
    public Student(String name, String surname, int age, String gender, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", Age: " + age + ", Gender: " + gender + ", ID: " + id;
    }
}
