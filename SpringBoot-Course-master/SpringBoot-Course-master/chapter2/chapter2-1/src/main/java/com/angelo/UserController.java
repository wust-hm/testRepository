package com.angelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @date 2020/9/6 16:14
 * @author zhong
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * @description: 保存一个用户
     * @param userParams: 用户参数列表
     * @return: com.angelo.User
     * @date: 2020/8/19 8:10
     */
    @PostMapping(value = "/user")
    public User userAdd(@RequestBody User userParams) {
        User user = new User();
        user.setName(userParams.getName());
        user.setAge(userParams.getAge());

        return userRepository.save(user);
    }

    /**
     * @description: 查询用户列表
     * @param : 无参数
     * @return: java.util.List<com.angelo.User>
     * @date: 2020/8/23 22:22
     */
    @RequestMapping(value = "/user/list")
    public List<User> userList() {
        return userRepository.findAll();
    }

    /**
     * @description: 根据id查找一个用户
     * @param id: 用户id
     * @return: java.util.Optional<com.angelo.User>
     * @date: 2020/8/23 22:21
     */
    @RequestMapping(value = "/user/{id}")
    public Optional<User> userFindOne(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    /**
     * @description: 根据name获取用户信息
     * @param name: 用户名字
     * @return: java.util.List<com.angelo.User>
     * @date: 2020/8/23 22:23
     */
    @RequestMapping(value = "/user/name", method = RequestMethod.GET)
    public List<User> findUserListByName(@RequestParam(name="name",defaultValue="") String name) {
        return userRepository.findByName(name);
    }

    /**
     * @description: 更新用户信息
     * @param id:
     * @param name:
     * @param age:
     * @return: com.angelo.User
     * @date: 2020/8/23 22:24
     */
    @PutMapping(value = "/user/{id}")
    public User userUpdate(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);

        return userRepository.save(user);
    }

    /**
     * @description: 删除一个用户信息
     * @param id: 用户id
     * @return: void
     * @date: 2020/8/23 22:25
     */
    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
