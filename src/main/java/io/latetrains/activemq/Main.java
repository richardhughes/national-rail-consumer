package io.latetrains.activemq;

import io.latetrains.activemq.consumer.ConverterConsumer;

public class Main {

    public static void main(String[] args) {
        Thread t = new Thread(new ConverterConsumer("darwin_data"));
        t.start();
    }
}
