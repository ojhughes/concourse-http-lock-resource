package io.pivotal.spring.cloud.services.resourcelock.model;

import java.sql.Timestamp;

import lombok.Data;

import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.LocksRecord;

@Data
public class Lock {

	private int id;
	private Timestamp claimedTime;
	private String claimedBy;
	private Environment environment;

	public Lock(LocksRecord locksRecord) {
		this.id = locksRecord.getId();
		this.claimedTime = locksRecord.getClaimedTime();
		this.claimedBy = locksRecord.getClaimedBy();
	}
}
