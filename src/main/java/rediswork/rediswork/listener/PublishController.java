package rediswork.rediswork.listener;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liutf
 * @date 2020-03-10
 */
@RequestMapping("/queue")
@Api("队列展示")
@RestController
public class PublishController {
    @Resource
    private PublisherService service;

    @GetMapping("/publishMsg")
    @ApiOperation("消息队列生产者")
    public void publishMsg(@RequestParam String msg) {
        service.publish(msg);
    }

    @GetMapping("/leftPutList")
    @ApiOperation("消息队列生产者")
    public void leftPutList(@RequestParam String msg) {
        service.leftPutList(msg);
    }
}
