/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.immigration.employee.shared;

/**
 * Message type used in Splunk logging messages.
 * @author Brad Mongeon
 */
// @SuppressWarnings("checkstyle:javadocvariable")
public enum MessageType {

	CHUNK_STATUS,
	ITEM_PROCESS,
	ITEM_READ,
	ITEM_WRITE,
	JOB_STATUS,
	STEP_STATUS;
}