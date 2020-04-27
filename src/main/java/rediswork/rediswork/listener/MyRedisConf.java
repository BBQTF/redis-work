package rediswork.rediswork.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author liutf
 * @date 2020-03-10
 */
@Configuration
public class MyRedisConf {

    /**
     * 新建一个Redis消息监听器容器，然后将监听器和管道名绑定，最后返回这个容器。
     **/
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("mytopic"));
        return container;
    }
    /**
     * 绑定消息监听者和接收监听的方法,必须要注入这个监听器，不然会报错
     **/
    @Bean
    public MessageListenerAdapter listenerAdapter() {
        return new MessageListenerAdapter(new Receiver(), "receiveMessage");
    }
}
