package cn.itcast.user.web;

import cn.itcast.user.config.PatternPropertiesConfig;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;
    //在user-service中的UserController中添加业务逻辑，读取pattern.dateformat配置：  实现热更新方法一
//    @Value("${pattern.dateformat}")
//    private String dateformat;
//
//    @GetMapping("now")
//    public String now(){
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
//    }

    /*热更新方法二*/
    @Autowired
    private PatternPropertiesConfig patternPropertiesconfig;

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternPropertiesconfig.getDateformat()));
    }

    /*读取共享配置*/
    @GetMapping("prop")
    public PatternPropertiesConfig prop(){
        return patternPropertiesconfig;
    }
    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth",required = false) String truth) {
        System.out.println("truth:" + truth);
        return userService.queryById(id);
    }
}
