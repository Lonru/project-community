package com.lonru.community.domain.user.dto;

import lombok.Data;

@Data
public class UpdateReqDto {
	private String password;
	private String email;
	private String nickname;
}
