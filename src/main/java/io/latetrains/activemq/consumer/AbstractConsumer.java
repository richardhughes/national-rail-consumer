package io.latetrains.activemq.consumer;

import org.apache.activemq.transport.stomp.Stomp;
import org.apache.activemq.transport.stomp.StompConnection;

import java.util.Properties;

public abstract class AbstractConsumer implements Runnable {

    protected StompConnection connection;

    public AbstractConsumer(String queueName)
    {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

            connection = new StompConnection();
            connection.open(prop.getProperty("host"), 61613);

            connection.connect("admin", prop.getProperty("password"));

            connection.subscribe("/queue/" + queueName, Stomp.Headers.Subscribe.AckModeValues.CLIENT);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
