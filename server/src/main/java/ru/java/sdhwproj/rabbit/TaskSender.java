package ru.java.sdhwproj.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.springframework.util.SerializationUtils;
import ru.java.sdhwproj.models.Submission;

/**
 * Represents class that sends tasks
 */
public class TaskSender {
    private static final String QUEUE_NAME = "SD-HwProj";

    public static void sendTask(Submission submission) throws Exception  {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            byte[] byteArray = SerializationUtils.serialize(submission);
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, byteArray);
            System.out.println(" [x] Sent '");
        }
    }

}
