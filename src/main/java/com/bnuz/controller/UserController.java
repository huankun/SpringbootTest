package com.bnuz.controller;

import com.bnuz.mapper.UserMapper;
import com.bnuz.pojo.User;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/userlist",method = RequestMethod.GET)
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

//    http://localhost:8080/swagger-ui.html
    @ApiOperation("Hello GET请求带参数")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(
//            默认为value 也就是注释 name属性暂时不要去添加
                        @ApiParam("输入一个名字")
                        @RequestParam("username") String username,
                        @ApiParam("输入一个密码")
                        @RequestParam("password") String password
                        ){
        return "hello " + username +" password"+password;
    }

//    @ApiOperation("Hello POST请求带参数")
//    @RequestMapping(value = "/hello2/{username:}",method = RequestMethod.POST)
//    public String Hello2(@ApiParam(name = "输入一个名字",value = "aaa")
//                         @PathVariable String username){
//        return "hello" + username;
//    }

    @RequestMapping(value = "/pet",method = RequestMethod.GET)
    public Map<String,Object> getPet2(@RequestParam("name") String name,
                                      @RequestParam List<Integer> age){
        Map<String,Object> map = new HashMap<>();

        map.put("name",name);
        map.put("age",age);
        return map;
    }
}
