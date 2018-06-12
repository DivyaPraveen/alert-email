/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.immigration.employee.shared;

/**
 * Status type for use in Splunk logging messages.
 * @author Brad Mongeon
 */
// @SuppressWarnings("checkstyle:javadocvariable")
public enum MessageStatus {

	AFTER,
	BEFORE,
	ERROR,
	JOB_ALREADY_RUNNING,
	JOB_COMPLETED,
	JOB_FAILED,
	PROCESSED,
	PROCESSING,
	STARTED,
	START_FAILED,
	START_REQUESTED,
	START_SUCCEEDED,
	NOT_STARTED;
}