package com.qidaiai.pay;

import java.util.Map;

public class TestPay {

    public static void main(String[] args) {
        String outTradeNo="OD12344557712315";
        String subject="SXT-医疗管理系统支付平台";
        String totalAmount="980";
        String undiscountableAmount=null;
        String body="买药用的";
        String notifyUrl="localhost:8080/pay/callback/" + outTradeNo;
        System.out.println(notifyUrl);
        Map<String, Object> pay = PayService.pay(outTradeNo, subject, totalAmount, undiscountableAmount, body, notifyUrl);
        System.out.println(pay);
    }
}
