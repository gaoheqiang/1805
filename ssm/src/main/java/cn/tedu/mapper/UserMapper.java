package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tedu.pojo.User;

public interface UserMapper {
  
	public List<User> findAll();
	
	@Select("select * from user where id=#{id}")
	public User getUserByID(@Param("id")Integer id);//这里注意要加个注解
	
	@Insert("INSERT INTO user(id,NAME,birthday,address) VALUES (#{id},#{name},#{birthday},#{address});")
	public void insert(User user);
	
	@Update("UPDATE user SET NAME=#{name} WHERE id=#{id}")
	public void update(User user);
	
	@Delete("DELETE FROM user WHERE id=#{id}")
	public void delete(Integer id);
	
}
