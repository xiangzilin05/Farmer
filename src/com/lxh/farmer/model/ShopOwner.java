package com.lxh.farmer.model;

import java.io.Serializable;

public class ShopOwner implements Serializable {



	@Override
	public String toString() {
		return "ShopOwner [editionId=" + editionId + ", authStatusId="
				+ authStatusId + ", CustomerUser=" + CustomerUser + ", userId="
				+ userId + ", UserName=" + UserName + ", comId=" + comId
				+ ", UserTypeId=" + UserTypeId + ", registered=" + registered
				+ ", loginProvider=" + loginProvider + ", userPassword="
				+ userPassword + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int editionId;

	public int getEditionId() {
		return editionId;
	}

	public void setEditionId(int editionId) {
		this.editionId = editionId;
	}

	public int getAuthStatusId() {
		return authStatusId;
	}

	public void setAuthStatusId(int authStatusId) {
		this.authStatusId = authStatusId;
	}

	public boolean isCustomerUser() {
		return CustomerUser;
	}

	public void setCustomerUser(boolean customerUser) {
		CustomerUser = customerUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public int getUserTypeId() {
		return UserTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		UserTypeId = userTypeId;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public String getLoginProvider() {
		return loginProvider;
	}

	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	private int authStatusId;
	private boolean CustomerUser = false;
	private String userId;
	private String UserName;
	private int comId;
	private int UserTypeId;
	private boolean registered;
	private String loginProvider;
	private String userPassword;

}
