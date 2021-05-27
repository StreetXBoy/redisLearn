
import redis.clients.jedis.Jedis;
/**
 * @author 重新做人idea基础学习
 * @date 2021-5-26
 */
public class jedisApp {
    public static void main(String[] args) {
        Jedis jeids =new  Jedis("47.101.176.203",6379);

        String name = jeids.get("name");

        System.out.println(name);

        jeids.close();
    }
}
