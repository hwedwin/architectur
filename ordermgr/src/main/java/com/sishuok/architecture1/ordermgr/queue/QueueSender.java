package com.sishuok.architecture1.ordermgr.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;

import javax.jms.*;
import java.util.Objects;

public class QueueSender {
    private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            "tcp://192.168.1.205:61616");

    public static void sendMsg(int customerUuid) {
        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("order-queue");

            ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session
                    .createProducer(destination);

            TextMessage message = session.createTextMessage("" + customerUuid);

            producer.send(message);

            session.commit();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            try {
                if (!Objects.isNull(session)) {
                    session.close();
                }

            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                if (!Objects.isNull(session)) {
                    connection.close();
                }

            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}