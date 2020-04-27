package rediswork.rediswork.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import rediswork.rediswork.common.util.RedisUtils;

/**
 * 生产者
 *
 * @author liutf
 * @date 2020-03-10
 */
@Service
public class PublisherService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void publish(String msg) {
        redisTemplate.convertAndSend("mytopic", msg);
    }

    public void leftPutList(String msg) {
        RedisUtils.llSet("mytopic", msg);
    }
}
