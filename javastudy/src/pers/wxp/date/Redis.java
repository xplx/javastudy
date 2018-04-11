package pers.wxp.date;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author wuxiaopeng
 * @create 2018-04-11 16:59
 **/

public class Redis {
    public static void main(String[] args) {

    }

    @Test
    public void testJedisSingle() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name", "itheiam");
        jedis.set("name1", "123");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
        //选择redis的数据数
        String s = jedis.select(1);
        String name1 = jedis.get("name");
        System.out.println(name1);
    }
}   