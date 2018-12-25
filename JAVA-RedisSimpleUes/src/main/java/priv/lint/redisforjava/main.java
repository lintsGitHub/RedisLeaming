package priv.lint.redisforjava;

import redis.clients.jedis.Jedis;

public class main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.set("hello","hhhhhhh");
        String hello = jedis.get("hello");
        System.out.println(hello);
        jedis.append("hello","word");
        System.out.println(jedis.get("hello"));
        jedis.del("hello");
        System.out.println(jedis.exists("hello"));
    }
}
