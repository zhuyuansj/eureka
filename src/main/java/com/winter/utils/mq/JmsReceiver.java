package com.winter.utils.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsReceiver {
    private final static  String DEFAULT_USER = "admin";//mq的账号
    private final static String DEFAULT_PASSWORD = "admin";//mq的密码
    public static void main(String[] args) throws JMSException {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
//                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        String default_user = "admin";
        String default_password = "admin";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_USER,
                DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        // JMS 客户端到JMS Provider 的连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // Session： 一个发送或接收消息的线程
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        // Destination ：消息的目的地;消息发送给谁.
        // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
        Destination destination = session.createQueue("my-queue");
        // 消费者，消息接收者
        MessageConsumer consumer = session.createConsumer(destination);
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            if (null != message) {
                System.out.println("收到消息：" + message.getText());
                session.commit();
            } else
                break;
        }
        session.close();
        connection.close();
    }

}
