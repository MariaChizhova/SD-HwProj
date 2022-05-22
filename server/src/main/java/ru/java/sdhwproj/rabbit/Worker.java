package ru.java.sdhwproj.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import ru.java.sdhwproj.models.Submission;
import org.springframework.util.SerializationUtils;

public class Worker {
    private static final String QUEUE_NAME = "SD-HwProj";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for tasks. To exit press CTRL+C");

        channel.basicQos(1);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            Submission submission = (Submission) SerializationUtils.deserialize(delivery.getBody());
            System.out.println(" [x] Received '");
            try {
                if (submission == null) {
                    throw new IllegalArgumentException("Submission is empty, can't deserialize it.");
                }
                runProcess(submission);
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }

    private static void runProcess(Submission submission) {
        try {
            // TODO:
            System.out.println(submission.getId());
            System.out.println(submission.getHomeworkId());
            System.out.println(submission.getTime());
            System.out.println(submission.getSolution());
            System.out.println(submission.getResult());
            System.out.println(submission.getProgramOutput());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
