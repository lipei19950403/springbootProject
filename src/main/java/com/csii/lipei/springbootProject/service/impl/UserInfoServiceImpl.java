package com.csii.lipei.springbootProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csii.lipei.springbootProject.entity.User;
import com.csii.lipei.springbootProject.mapper.UserMapper;
import com.csii.lipei.springbootProject.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUser() {
		return userMapper.queryUser();
	}

}
