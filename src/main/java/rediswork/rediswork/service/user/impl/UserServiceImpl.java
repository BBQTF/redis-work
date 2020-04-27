package rediswork.rediswork.service.user.impl;

import org.springframework.stereotype.Service;
import rediswork.rediswork.bean.user.UserBean;
import rediswork.rediswork.common.util.RedisUtils;
import rediswork.rediswork.dto.user.UserDto;
import rediswork.rediswork.mapper.UserMapper;
import rediswork.rediswork.service.user.UserService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author liutf
 * @date 2020-02-28
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Override
    public UserDto findUsersByLoginName(String username) {
        UserBean bean = mapper.getUserDetail(username);
        if (bean != null) {
            return bean.transToDto(bean);
        }
        return null;
    }

    /**
     * 获取当前最新登录的5名用户的用户名list
     * @return
     */
    @Override
    public Object getTopFiveUser() {

        Integer top = 5; //设置默认值
        Object userNames = RedisUtils.lGet("top", 0, top);
        return userNames;
    }

    /**
     * 获取当前最新登录的5名用户的用户名sorted set
     *
     * @return
     */
    @Override
    public Object getTopUniUser() {
        Object userNames = RedisUtils.zsGet("uniTop");
        return userNames;
    }

    /**
     * 登录并将登录成功的用户名写入redis
     *
     * @param username
     * @param password
     * @return
     */
    public Integer login(String username, String password) {

        Integer count = mapper.login(username, password);
        if (count > 0) {
            // 使用list缓存登录名
            setTopUser(username);
            // 使用sorted set缓存登录名
            setTopUniUser(username);
        }
        return count;
    }

    /**
     * 缓存用户名list
     *
     * @param username
     */
    public void setTopUser(String username) {
        RedisUtils.fixSizeLSet("top", username, 5);// 设置缓存默认容量
    }

    /**
     * 缓存用户名至set
     *
     * @param username
     */
    public void setTopUniUser(String username) {
        RedisUtils.fixSizeZSSet("uniTop", username, 5);// 设置缓存默认容量
    }

    /**
     * 获取String随机验证码
     *
     * @param phoneNum
     * @return
     */
    @Override
    public String getCode(String phoneNum) {

        // 判断redis中是否存在phoneNum的key
        if (RedisUtils.hasKey(phoneNum)) {
            return (String) RedisUtils.get(phoneNum);
        }
        // 生成4位的随机验证码
        StringBuilder randomCode = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomCode.append(new Random().nextInt(10));
        }
        // 将生成的验证码存入redis并设置过期时间
        boolean cacheCode = RedisUtils.set(phoneNum, randomCode.toString(), 20);
        if (!cacheCode) {
            //
        }
        return randomCode.toString();
    }
}
