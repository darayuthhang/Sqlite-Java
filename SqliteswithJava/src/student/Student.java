package student;

public class Student {
    private int id ;
    private String name;
    private String sex;
    public Student(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString(){
        return "{"+ "id:" + getId()+ "name:" + getName() + "sex:" + getSex() + "}";
    }


}
