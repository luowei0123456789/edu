package com.luowei.service_sms.service.impl;

import java.util.Map;

public interface SmsService {
    //发送短信的方法
    boolean send(Map<String, Object> param, String phone);
}
