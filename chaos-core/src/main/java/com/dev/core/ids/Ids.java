package com.dev.core.ids;




import com.dev.core.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <code>Ids </code>
 * ID生成器工具类，此工具类中主要封装：
 *
 * <pre>
 * 1. 唯一性ID生成器：UUID、ObjectId（MongoDB）、Snowflake
 * </pre>
 *
 * <p>
 * ID相关文章见：http://calvin1978.blogcn.com/articles/uuid.html
 *
 * @author liaochunshui
 * @author Siu
 * @version v1.0
 * @date 2021/1/25
 * @since JDK1.8
 */
public class Ids {

    /**
     * 码表
     */
    private final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};


    /**
     * nanoTime UUID
     *
     * @return
     */
    public static String nanoTimeUniqueId() {
        return Long.toString(System.nanoTime(), Character.MAX_RADIX);
    }


    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 随机ID
     *
     * @param length ID 长度
     * @return
     */
    public static String randomId(int length) {
        char[] cs = new char[length];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = digits[ThreadLocalRandom.current().nextInt(digits.length)];
        }
        return new String(cs);
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID() {
        return StringUtils.remove(UUID.randomUUID().toString(), "-");
    }


    /**
     * 创建Twitter的Snowflake 算法生成器<br>
     * 分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。
     *
     * <p>
     * snowflake的结构如下(每部分用-分开):<br>
     *
     * <pre>
     * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
     * </pre>
     *
     * 第一位为未使用，接下来的41位为毫秒级时间(41位的长度可以使用69年)<br>
     * 然后是5位datacenterId和5位workerId(10位的长度最多支持部署1024个节点）<br>
     * 最后12位是毫秒内的计数（12位的计数顺序号支持每个节点每毫秒产生4096个ID序号）
     *
     * <p>
     * 参考：http://www.cnblogs.com/relucent/p/4955340.html
     *
     * @param workerId 终端ID
     * @param dataCenterId 数据中心ID
     * @return {@link Snowflake}
     */
    public static Snowflake createSnowflake(long workerId, long dataCenterId) {
        return new Snowflake(workerId, dataCenterId);
    }




}
