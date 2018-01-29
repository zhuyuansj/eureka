package com.winter.utils.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "${queue}")//表示是哪个队列,项目开启后就会进行监听
    public void receive(String msg) {
        System.out.println("监听器收到msg:" + msg);
//
//       JSONObject jsonObject = new Jsonobject();
//       UserEntity userEntity = jsonObject.parseObject(msg,UserEntity.class);
//        System.out.println(userEntity.getName()+"---"+userEntity.getId());
    }

}
