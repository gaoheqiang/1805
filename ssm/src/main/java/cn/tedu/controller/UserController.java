package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;


@RestController//用restfull形式请求 返回值是 json
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public List<User> getAll(){
		
		return userService.findAll();
	}
	
	@RequestMapping("/getUser/{id}")
	public User getUser(@PathVariable Integer id){
		return userService.getUserByID(id);
	}
	
	//这里注意了就是  虽然是restfull风格的 但是不用加@PathVariable;
	//时间格式一定要注意啊就是。
	@RequestMapping("/insert/{id}/{name}/{birthday}/{address}")
	public User insertUser(User user){
		
		
		userService.insert(user);
		return user;
	}
	
	@RequestMapping("/update/{id}/{name}")
	public String updateUser(User user){
		try {
			userService.update(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "faild";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id){
		try {
			userService.delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "faild";
	}
	

}
