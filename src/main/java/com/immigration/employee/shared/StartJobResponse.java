/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.immigration.employee.shared;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Model of the StartJobResponse type.
 * @author Brad Mongeon
 */
public class StartJobResponse {

	private Boolean started = false;

	private String jobId;

	private String jobStatus;

	public Boolean getStarted() {
		return this.started;
	}

	public void setStarted(final Boolean started) {
		this.started = started;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(final String jobId) {
		this.jobId = jobId;
	}

	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(final String jobStatus) {
		this.jobStatus = jobStatus;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}