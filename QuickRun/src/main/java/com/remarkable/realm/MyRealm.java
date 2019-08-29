package com.remarkable.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.remarkable.entity.User;
import com.remarkable.service.ILoginService;

@Component
public class MyRealm extends AuthenticatingRealm {

	@Autowired
	private ILoginService loginService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo:" + token);

		//1.把AuthenticationToken 转换为 UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.从UsernamePasswordToken 中获取phone
		String phone = upToken.getUsername();
		//3.调用数据库的方法，从数据库中查询phone 对应的用户记录
		User user = loginService.login(phone);
		//4.若用户不存在，则抛出UnknownAccountException异常
		
		//5.根据用户信息的情况，决定是否需要抛出其他AuthenticationException
		
		//6.根据用户的情况，来构建AuthenticationInfo 对象并返回
		if(user != null) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getU_phone(),user.getU_pwd(),"myRealm");
			return info;
		}
		return null;
	}

	/**
	 * 在登陆成功之后，设置用户的角色和权限
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//获取手机号
		String phone = (String) principals.getPrimaryPrincipal();
		//设置授权信息
		SimpleAuthorizationInfo  info = new SimpleAuthorizationInfo ();
		//设置角色
		info.setRoles(loginService.getRoles(phone));
		//设置权限
		info.setStringPermissions(loginService.getPerms(phone));
		return info;
	}
}
