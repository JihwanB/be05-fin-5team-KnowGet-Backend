package com.knowget.knowgetbackend.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobUpdateDTO {

	private Short job;
	private String username;

}
