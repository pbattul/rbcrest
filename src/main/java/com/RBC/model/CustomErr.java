package com.RBC.model;

import org.springframework.stereotype.Component;

public class CustomErr {
	
	String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public CustomErr(String errorMsg){
        this.errorMsg = errorMsg;
    }

}
