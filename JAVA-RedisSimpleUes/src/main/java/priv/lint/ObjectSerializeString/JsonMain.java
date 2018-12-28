package priv.lint.ObjectSerializeString;


import com.google.gson.Gson;

public class JsonMain {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("李四");
        student.setAge(34);
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
        Student student1 = gson.fromJson(s, Student.class);
        System.out.println(student1);
    }
}
