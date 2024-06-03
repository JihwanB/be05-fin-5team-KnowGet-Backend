package com.knowget.knowgetbackend.domain.successCase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.knowget.knowgetbackend.global.entity.SuccessCase;

@Repository
public interface SuccessCaseRepository extends JpaRepository<SuccessCase, Integer> {

	// SuccessCase 검색 - By Using "Keyword"
	List<SuccessCase> findByTitleContaining(String keyword);

	// SuccessCase 승인상태 업데이트 - updateApprovalStatus
	@Modifying
	@Query("update SuccessCase sc set sc.isApproved = :status where sc.caseId = :caseId")
	void updateApprovalStatus(@Param("caseId") Integer caseId, @Param("status") Short status);
}
