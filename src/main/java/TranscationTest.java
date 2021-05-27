import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @author 重新做人idea基础学习
 * @date 2021-5-26
 */


// redis之事务！！！
public class TranscationTest {
    public static void main(String[] args) {
        Jedis jeids =new  Jedis("47.101.176.203",6379);

        // setnx ??  set if not exits
        jeids.setnx("chenxr","5");
        System.out.println(DoubleAccount(jeids,"chenxr"));
        jeids.close();

    }



    public  static  int DoubleAccount(Jedis jedis ,String id) {
        while (true) {
            jedis.watch(id);
            int val = Integer.parseInt(jedis.get(id));
            val *= 2;

            // mutil --- > begin
            // exc ---> execute
            // discard --> quit

            Transaction tx = jedis.multi();
            tx.set(id, String.valueOf(val));
            List<Object> res = tx.exec();
            System.out.println(res);
            if (res != null) {
                break;
            }
        }
        return Integer.parseInt(jedis.get(id));
    }

}
