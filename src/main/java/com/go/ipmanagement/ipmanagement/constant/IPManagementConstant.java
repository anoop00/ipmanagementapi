package com.go.ipmanagement.ipmanagement.constant;

// This class can be transfer to the constant table which we can load it at the time of starting of application
// Use cache to strore the data
public class IPManagementConstant {

	public static final String ipRegex = "(?<=\\.)(?!.*\\.)";
	public static final String ipPoolErrorMessage = "Insufficient IP Address Port available for the given pool Id ";
	public static final String ipPoolNotFoundError = "No IP Pool exist in the database with given ID";
}
