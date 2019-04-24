package com.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class MyUtil {
    /**
     * 生成UUID,32位
     * @return id
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        //去掉随机ID的短横线
        id = id.replace("-", "");

        return id;
    }

    /**
     * 生成表ID,纯数字，递增，22位左右
     * @return id
     */
    public static String getTableId() {
        //取UUID的哈希码，换成纯数字
        int num = getUUID().hashCode();
        //去绝对值
        num = num < 0 ? -num : num;
//		在生成的随机数字前加入时间戳，形成递增
        return String.valueOf(System.currentTimeMillis()) + num;
    }

    /**
     * 生成18位订单号
     */
    public static String getOrderId() {
        OrderIdFactory orderIdFactory = new OrderIdFactory(1, 2);
        long orderId = orderIdFactory.nextId();

        return String.valueOf(orderId);
    }

    /**
     * 生成当前时间
     */
    public static Date nowTime(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    /**
     * 密码加密方法
     */
    public static String md5(String psw) {
        //md5加密
        return DigestUtils.md5Hex(psw);
    }

}
