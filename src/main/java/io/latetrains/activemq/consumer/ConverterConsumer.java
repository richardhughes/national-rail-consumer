package io.latetrains.activemq.consumer;

import io.latetrains.activemq.utils.ZipUtils;
import org.apache.activemq.transport.stomp.StompFrame;

public class ConverterConsumer extends AbstractConsumer {

    public ConverterConsumer(String queueName) {
        super(queueName);
    }

    @Override
    public void run() {
        while (true) {
            try {
                StompFrame message = connection.receive();

                String xml = ZipUtils.unGzip(message.getContent());
                connection.ack(message);
                System.out.println(xml);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
