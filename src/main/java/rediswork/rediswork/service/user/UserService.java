package rediswork.rediswork.service.user;

import rediswork.rediswork.dto.user.UserDto;


/**
 * @author liutf
 * @date 2020-02-28
 */
public interface UserService {
    UserDto findUsersByLoginName(String username);
    String getCode(String phoneNum);
    Object getTopFiveUser();
    Object getTopUniUser();
    Integer login(String username, String password);
}
