package com.lonru.community.service;

import com.lonru.community.domain.user.User;
import com.lonru.community.domain.user.UserDao;
import com.lonru.community.domain.user.dto.JoinReqDto;
import com.lonru.community.domain.user.dto.LoginReqDto;
import com.lonru.community.domain.user.dto.UpdateReqDto;

public class UserService {
	private UserDao userDao;
	public UserService() {
		this.userDao = new UserDao();
	}
	public int 회원가입(JoinReqDto dto) {

		int result = userDao.save(dto);
		return result;
	}

	public User 로그인(LoginReqDto dto) {

		return userDao.findByUsernameAndPassword(dto);
	}

	public int 회원수정(UpdateReqDto dto) {

		return -1;
	}

	public int 유저네임중복체크(String username) {
		int result = userDao.findByUsername(username);
		return result;
	}
}
