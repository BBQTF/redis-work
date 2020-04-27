package rediswork.rediswork.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消费者
 * @author liutf
 * @date 2020-03-10
 */
public class Receiver {
    private final static Logger logger = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message) {
        logger.info("receive_____" + message);
    }
}
