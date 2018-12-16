package com.bucom.security.controller;

import com.bucom.security.model.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    /***
     *
     * @param usera
     * @RequestParam(required = false):不传的话不会报错;
     * @PageableDefault():默认给的分页参数设置
     * @return
     */
    @RequestMapping(value = "/user",method=RequestMethod.GET)
    @JsonView(User.UserSimpleView.class)
    public List<User> queryRestful(@RequestParam(value = "username",required = false) String usera,@PageableDefault(size = 17,sort = "uname,desc") Pageable pageable){
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
        User u=new User();
        u.setUsername("tom");
        u.setPassword("123");
        return u;
    }


}
