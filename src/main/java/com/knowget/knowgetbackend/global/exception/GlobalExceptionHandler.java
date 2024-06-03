package com.knowget.knowgetbackend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.knowget.knowgetbackend.domain.answer.exception.AnswerNotFoundException;
import com.knowget.knowgetbackend.domain.comment.exception.CommentNotFoundException;
import com.knowget.knowgetbackend.domain.comment.exception.SuccessCaseNotFoundException;
import com.knowget.knowgetbackend.domain.counseling.exception.CounselingNotFoundException;
import com.knowget.knowgetbackend.domain.jobGuide.exception.ResourceNotFoundException;
import com.knowget.knowgetbackend.domain.reply.exception.ReplyNotFoundException;
import com.knowget.knowgetbackend.domain.user.exception.InvalidPasswordException;
import com.knowget.knowgetbackend.domain.user.exception.UserNotFoundException;
import com.knowget.knowgetbackend.global.dto.ResultMessageDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ResultMessageDTO> handleIllegalArgumentException(IllegalArgumentException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResultMessageDTO> handleUserNotFoundException(UserNotFoundException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ResultMessageDTO> handleInvalidPasswordException(InvalidPasswordException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(SuccessCaseNotFoundException.class)
	public ResponseEntity<ResultMessageDTO> handleSuccessCaseNotFoundException(SuccessCaseNotFoundException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CommentNotFoundException.class)
	public ResponseEntity<ResultMessageDTO> handleCommentNotFoundException(CommentNotFoundException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AnswerNotFoundException.class)
	public ResponseEntity<ResultMessageDTO> handleAnswerNotFoundException(AnswerNotFoundException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CounselingNotFoundException.class)
	public ResponseEntity<ResultMessageDTO> handleCounselingNotFoundException(CounselingNotFoundException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequestFailedException.class)
	public ResponseEntity<ResultMessageDTO> handleRequestFailedException(RequestFailedException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ReplyNotFoundException.class)
	public ResponseEntity<ResultMessageDTO> handleReplyNotFoundException(ReplyNotFoundException e) {
		return new ResponseEntity<>(new ResultMessageDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

}
