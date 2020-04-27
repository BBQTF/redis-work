package rediswork.rediswork.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rediswork.rediswork.common.ResultVo;
import rediswork.rediswork.dto.user.UserDto;
import rediswork.rediswork.service.user.UserService;


import javax.annotation.Resource;


/**
 * @author liutf
 * @date 2020-02-28
 */
@RestController
@RequestMapping("/system/user")
@Api("redis-支持的数据类型应用场景展示")
public class UserController {
    @Resource
    private UserService service;

    @GetMapping("/queryByLoginName")
    @ApiOperation("根据登录名查询用户信息")
    public ResultVo findUsersByLoginName(@RequestParam String username) {
        ResultVo resultVo = new ResultVo();
        try {
            UserDto dto = service.findUsersByLoginName(username);
            resultVo.setData(dto);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setCode(1);
        }
        return resultVo;
    }

    @GetMapping("/getCode")
    @ApiOperation("String：获取随机验证码")
    public ResultVo getCode(@RequestParam String phoneNum) {
        ResultVo resultVo = new ResultVo();
        try {
            String code = service.getCode(phoneNum);
            resultVo.setData(code);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setCode(1);
        }
        return resultVo;
    }


    @GetMapping("/getTopFiveUser")
    @ApiOperation("List：获取当前最新登录的用户名top5-未去重")
    public ResultVo getTopFiveUser() {
        ResultVo resultVo = new ResultVo();
        try {
            Object userIdList = service.getTopFiveUser();
            resultVo.setData(userIdList);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setCode(1);
        }
        return resultVo;
    }

    @GetMapping("/getTopFiveUniUser")
    @ApiOperation("sorted set：获取当前最新登录的用户名top5")
    public ResultVo getTopFiveUniUser() {
        ResultVo resultVo = new ResultVo();
        try {
            Object userIdList = service.getTopUniUser();
            resultVo.setData(userIdList);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setCode(1);
        }
        return resultVo;
    }

    @GetMapping("/login")
    @ApiOperation("登录")
    public ResultVo login(@RequestParam String username, @RequestParam String password) {
        ResultVo resultVo = new ResultVo();
        try {
            Integer count = service.login(username, password);
            if (count < 0) {
                resultVo.setCode(1);
                resultVo.setData("用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setCode(1);
        }
        return resultVo;
    }
}
