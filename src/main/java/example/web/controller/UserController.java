package example.web.controller;

import example.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 李恒名 on 2016/10/13.
 * <p>
 * RESTful API
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户服务",description = "提供RESTful风格API的用户的增删改查服务")
public class UserController {
    //模拟DAO层
    private final Map<Long, User> repository = new HashMap<Long, User>();

    @PostMapping
    @ApiOperation("添加用户")
    public Boolean add(@RequestBody User user) {
        repository.put(user.getId(), user);
        return true;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除用户")
    public Boolean delete(@PathVariable Long id) {
        repository.remove(id);
        return true;
    }

    @PutMapping
    @ApiOperation("更新用户")
    public Boolean update(@RequestBody User user) {
        repository.put(user.getId(), user);
        return true;
    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询用户")
    public User findById(@PathVariable Long id) {
        return repository.get(id);
    }
}
