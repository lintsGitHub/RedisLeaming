package priv.lint.ObjectSerializeString;

import com.google.gson.Gson;
import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class serializeMain {
    public static void main(String[] args) {
//        定义一个学生对象
        Student student = new Student();
        student.setName("张三");
        student.setAge(23);
        try {
            String s = serializeToString(student);
            System.out.println(s);
            Object object = serializeToObject(s);
            System.out.println(object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
    * 序列化
    * 传入一个学生对象，返回这个学生的序列化好的字符串
    * */
    public static String serializeToString(Student student) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(student);
        return byteArrayOutputStream.toString("ISO-8859-1");
    }

    /*
    * 反序列化
    * 传入一个字符串，然后返回一个对象
    * */
    public static Object serializeToObject(String s) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

    public String  toRedis(){
        Jedis jedis = new Jedis();
        Boolean key = jedis.exists("key");
        if (key){
            return jedis.get("key");
        }else {
            List list = new ArrayList();
            Gson gson = new Gson();
            String s = gson.toJson(list);
            return s;
        }
    }

}
