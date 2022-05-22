package ru.java.sdhwproj.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import java.sql.Timestamp;
import org.springframework.util.SerializationUtils;
import ru.java.sdhwproj.models.Submission;

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

    public static void main(String[] argv) throws Exception {
        // TODO: change it
        Submission submission = new Submission(1L, 1L, new Timestamp(System.currentTimeMillis()), "solution", 1, "output");
        sendTask(submission);
    }
}
