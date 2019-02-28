package org.camunda.loanApplication.loanApprovalPkg;

import org.camunda.loanApplication.loanApprovalPkg.LoanRequestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRequestRepo extends JpaRepository<LoanRequestList, Integer>{
	

}