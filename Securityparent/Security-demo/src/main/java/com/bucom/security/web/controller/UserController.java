package com.bucom.security.web.controller;

import com.bucom.security.exception.UserNullException;
import com.bucom.security.model.User;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    /***
     *
     * @param usera
     * @RequestParam(required = false):不传的话不会报错;
     * @PageableDefault():默认给的分页参数设置
     * @return
     */
    @ApiOperation(value = "查询所有的方法")
    @RequestMapping(value = "/user",method=RequestMethod.GET)
    @JsonView(User.UserSimpleView.class)
    public List<User> queryRestful(@ApiParam(value = "username") @RequestParam(value = "username",required = false) String usera, @PageableDefault(size = 17,sort = "uname,desc") Pageable pageable){
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> list=new ArrayList<>();
        list.add(new User("123","密码"));
        list.add(new User("223","密码"));
        list.add(new User("323","密码"));
        return list;
    }
    @JsonView(User.UserDetailView.class)
    @RequestMapping(value = "/user/{id}",method=RequestMethod.GET)
    public User getRestful(@PathVariable("id") String username){
        System.out.println("restful返回:"+username);
        if (null!=username){
            throw  new UserNullException(username);
        }
        User u=new User();
        u.setUsername("tom");
        u.setPassword("123");
        return u;
    }
    @RequestMapping(value = "/user",method=RequestMethod.POST)
    public User postInsertRestful(@RequestBody User user){
        System.out.println("RequestBody:"+user.getUsername());
        System.out.println("RequestBody:"+user.getPassword());
        System.out.println("RequestBody:"+user.getBirthday());
        System.out.println("RequestBody:"+user.getBirthday().getTime());

        User u=new User();
        u.setId("1");
        return u;
    }


    @RequestMapping(value = "/user/{id}",method=RequestMethod.PUT)
    public String putRestful(@RequestBody User user){
        System.out.println("RequestBody:"+user.getId());
        System.out.println("RequestBody:"+user.getUsername());
        System.out.println("RequestBody:"+user.getPassword());
        System.out.println("RequestBody:"+user.getBirthday());
        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("RequestBody:"+sdf.format(user.getBirthday()));*/

        return "success";
    }




}
