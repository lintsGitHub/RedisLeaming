package priv.lint.redisForSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class redisService {
    @Autowired
    JedisConnectionFactory factory;
    @Autowired
    RedisTemplate template;

    void addHello(){
        System.out.println(factory.getHostName());
        System.out.println(factory.getPort());
        RedisConnection connection = factory.getConnection();
        /*
        将hello写入到Redis数据库中
        这里的set或get的方法，是指对读写数据库
        都是采用的是字节流的方式
        */
        connection.set("hello".getBytes(),"hello".getBytes());
    }

    void sayHi(){
//        template.opsForSet().add("lint","hhhhh");
        Object lint = template.opsForValue().get("hello");
        System.out.println(lint);
    }
}
