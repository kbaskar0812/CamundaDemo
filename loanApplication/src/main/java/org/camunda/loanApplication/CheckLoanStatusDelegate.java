package org.camunda.loanApplication;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckLoanStatusDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Random rando = new Random();
		// TODO Auto-generated method stub
		execution.setVariable("name", "Baskar");
		execution.setVariable("processOk", rando.nextBoolean());

	}

}
