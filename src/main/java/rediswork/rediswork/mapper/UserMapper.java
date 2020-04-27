package rediswork.rediswork.mapper;

import org.apache.ibatis.annotations.Param;
import rediswork.rediswork.bean.user.UserBean;

/**
 * @author liutf
 * @date 2020-02-28
 */
public interface UserMapper {
    UserBean getUserDetail(@Param("username") String username);
    Integer login(String username, String password);
}
