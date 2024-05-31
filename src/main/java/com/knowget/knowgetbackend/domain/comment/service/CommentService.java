package com.knowget.knowgetbackend.domain.comment.service;

import java.util.List;

import com.knowget.knowgetbackend.domain.comment.dto.CommentDeleteDTO;
import com.knowget.knowgetbackend.domain.comment.dto.CommentRequestDTO;
import com.knowget.knowgetbackend.domain.comment.dto.CommentResponseDTO;
import com.knowget.knowgetbackend.domain.comment.dto.CommentUpdateDTO;

public interface CommentService {

	String saveComment(CommentRequestDTO commentRequestDto);

	List<CommentResponseDTO> findComments(Integer caseId);

	String updateComment(CommentUpdateDTO commentUpdateDTO);

	String deleteComment(CommentDeleteDTO commentDeleteDTO);

}