package priv.lint.redisForSpring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configurable
@ComponentScan(value = "priv.lint.redisForSpring")
public class SpringConfig {

    /*
    * 在使用Spring提供的RedisTemplate之前需要配置Spring所提供的连接工厂
    * 而在SpringDataRedis中就提供了四种工厂模式
    * 1,JredisConnectionFactory
    * 2,JedisConnectionFactory
    * 3,LettuceConnectionFactory
    * 4,SrpConnectionFactory
    * 其中我们最常用的是JedisConnectionFactory
    * */
//    这里可以对这个工厂设置很多属性，让它初始化时配置好
    @Bean
    JedisConnectionFactory factory(){
       return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate template(){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(factory());
//        我们都可以定义一些序列化对象给Template然后对数据进行序列化
//        stringRedisTemplate.setStringSerializer(new StringRedisSerializer());
        return stringRedisTemplate;
    }
}
