package cn.wolfcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisAppTests {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void testStringRedisTemplate(){
        ValueOperations<String, String> value = template.opsForValue();
        value.set("name","小新");

        System.out.println(value.get("name"));
    }

    @Test
    public void testJedisPool(){
        JedisPool jedisPool=new JedisPool();
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis);
        jedis.close();
        jedisPool.close();
    }
}
