import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 重新做人idea基础学习
 * @date 2021-5-26
 */
public class jedisPool {
    public static void main(String[] args) {
        String ip="47.101.176.203";

        int  port =6379;
        JedisPoolConfig config =new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setTestOnBorrow(true);

        JedisPool pool  =  new JedisPool(ip,port);

        try (Jedis jedis = pool.getResource()){
            System.out.println(jedis.get("name"));
        }
    }
}
