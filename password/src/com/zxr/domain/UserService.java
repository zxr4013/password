package com.zxr.domain;
/** 
* @author zxr:zhaoxinran_dlmuit@163.com 
* @version 创建时间：2017年12月21日 下午5:00:23 
* 类说明 业务层
*/

public class UserService {
	private UserDao userDao;
	public UserService(){
		//通过工厂实例化UserDao对象
		userDao = DaoFactory.getInstance().createUserDao();
		System.out.println("userDao:"+userDao);
	}
	//注册用户
	public void regist(User user){
		if(user == null){
			System.out.println("注册信息无效");
		}else{
			userDao.addUser(user);
		}
	}
	
	//查询用户
	public User query(String userName){
		User user = userDao.getUserByName(userName);
		if(user == null){
			System.out.println("查询结果为空!!");
		}else{
			System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getEmail()+"\t"+user.getPassword());
		}
		return userDao.getUserByName(userName);
		
	}
	
	//更新用户
	public void update(User user){
		if(user.getName() == null){
			System.out.println("用户名无效");
		}else{
			userDao.update(user);
		}
	}
	
	 // 删除用户
	 public void delete(User user){
		if(user.getName() == null){
			System.out.println("用户名无效,无法删除!!");
		}else{
			userDao.delete(user);
		}
	}
	

}
