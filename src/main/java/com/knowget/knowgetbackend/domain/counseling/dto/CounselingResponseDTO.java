package com.knowget.knowgetbackend.domain.counseling.dto;

import java.time.LocalDateTime;

import com.knowget.knowgetbackend.global.entity.Counseling;
import com.knowget.knowgetbackend.global.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounselingResponseDTO {
	private Integer counselingId;

	private User user;

	private String category;

	private String content;

	private Boolean isAnswered;

	private LocalDateTime sentDate;

	public CounselingResponseDTO(Counseling counseling) {
		this.counselingId = counseling.getCounselingId();
		this.user = counseling.getUser();
		this.category = counseling.getCategory();
		this.content = counseling.getContent();
		this.isAnswered = counseling.getIsAnswered();
		this.sentDate = counseling.getSentDate();
	}

}
