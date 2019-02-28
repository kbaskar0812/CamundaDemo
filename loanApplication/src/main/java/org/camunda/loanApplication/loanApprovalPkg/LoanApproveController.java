package org.camunda.loanApplication.loanApprovalPkg;

import java.io.IOException;

import javax.validation.Valid;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.loanApplication.loanApprovalPkg.LoanRequestList;
import org.camunda.loanApplication.loanApprovalPkg.LoanRequestRepo;
import org.camunda.loanApplication.loanApprovalPkg.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.camunda.loanApplication.loanApprovalPkg.StartCamundaProcess;


@RestController
@RequestMapping("/api")

public class LoanApproveController {
	@Autowired
	LoanRequestRepo loanRequestRepo;
	
	@GetMapping("/pingtest")
	public String getLoanList() {

		return "ping";
	}
	
	@RequestMapping(value = "/loanapply", method = RequestMethod.POST)
	public RestResponse loanApply(@Valid @RequestBody final LoanRequestList inLoanRequestList) throws IOException {
		System.out.println("BorrowerName=" +inLoanRequestList.getBorrowername());
		System.out.println("Amount=" +inLoanRequestList.getAmount());
		System.out.println("Document Verification=" +inLoanRequestList.isDocverify());
		System.out.println("Loan Status=" +inLoanRequestList.getStatus());
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("loanApplication");
		
		LoanRequestList requestList =	loanRequestRepo.save(inLoanRequestList);
		System.out.println("Process Instance=" +instance.getProcessInstanceId());
		
		//StartCamundaProcess.POSTRequest();
		
		return new RestResponse(RestResponse.SUCCESS,requestList);
	}

}
