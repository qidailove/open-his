package com.qidaiai.config.pay;

public class AlipayConfig {

    //应用的ID，申请时的APPID
    public static String app_id = "2016102800774370";

    //SHA256withRsa对应支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtRcGPPMKVseEVERjRxwgZ+pkdZkc75C0w5HdoVFYrJV3gpSDGJLqUEjOFG6/BCb3OUnr/gsg3OFJZZcW6Pz6tPsUJ5saD7ezhLpsNb32ZYbTh8vNDaynIflZlTYBLG79VXPRXBV4ayWkmSKZYg2V3/uZbBdIU35LBEOq0vetJ2s50zT516YyU+xvezzlJ/6ag2o4IjEu5n1JrqdU5UsER3Qfc6Ya0P7FYs8VUpIk3onBOoJfxeGnQP4HtaSgkYmK0ozpoccOIyqAPZY1hV43Oo7a4PZAaNJT4JNPiXEnX1+Fzpe/Fo54Xo4hAGW8vSoqXTtI3vSkTrDhWhnYBSns7QIDAQAB";    //签名方式
    public static String sign_type = "RSA2";
    //字码编码格式
    public static String charset = "utf-8";

    //回调地址
    public static String notifyUrl="http://3538q840p9.oicp.vip/pay/callback/";
}
