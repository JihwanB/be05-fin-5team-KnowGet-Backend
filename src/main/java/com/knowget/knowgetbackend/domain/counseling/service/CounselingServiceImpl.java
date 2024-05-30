package com.knowget.knowgetbackend.domain.counseling.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knowget.knowgetbackend.domain.counseling.dto.CounselingRequestDTO;
import com.knowget.knowgetbackend.domain.counseling.dto.CounselingResponseDTO;
import com.knowget.knowgetbackend.domain.counseling.exception.CounselingNotFoundException;
import com.knowget.knowgetbackend.domain.counseling.repository.CounselingRepository;
import com.knowget.knowgetbackend.domain.user.exception.UserNotFoundException;
import com.knowget.knowgetbackend.domain.user.repository.UserRepository;
import com.knowget.knowgetbackend.global.entity.Counseling;
import com.knowget.knowgetbackend.global.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounselingServiceImpl implements CounselingService {

	private final CounselingRepository counselingRepository;
	private final UserRepository userRepository;

	/** 최신 순으로 상담 목록 조회
	 *
	 * @return 상담 목록
	 * @author 근엽
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CounselingResponseDTO> getAllCounseling() {

		return counselingRepository.findAllByOrderBySentDateDesc().stream()
			.map(CounselingResponseDTO::new)
			.collect(Collectors.toList());
	}

	/** 상담 상세 조회
	 *
	 * @param id
	 * @return 상담 내용
	 * @author 근엽
	 * @throws CounselingNotFoundException
	 */
	@Override
	@Transactional(readOnly = true)
	public CounselingResponseDTO getCounselingById(Integer id) {

		Counseling counseling = counselingRepository.findById(id)
			.orElseThrow(() -> new CounselingNotFoundException("[ERROR] 해당 상담을 찾을 수 없습니다."));
		return new CounselingResponseDTO(counseling);
	}

	/** 상담 작성
	 *
	 * @param counselingRequestDTO
	 * @return 작성 완료 메시지
	 * @author 근엽
	 * @throws UserNotFoundException
	 */
	@Override
	public String saveCounseling(CounselingRequestDTO counselingRequestDTO) {
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userRepository.findByUsername(userId)
			.orElseThrow(() -> new UserNotFoundException("[ERROR] 회원정보가 입력되지 않았습니다."));

		Counseling couns = Counseling.builder()
			.user(user)
			.category(counselingRequestDTO.getCategory())
			.content(counselingRequestDTO.getContent())
			.build();
		counselingRepository.save(couns);
		return "상담이 저장되었습니다.";
	}

}


