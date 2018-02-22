package io.pivotal.spring.cloud.services.resourcelock.model;

import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.EnvironmentsRecord;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.PoolsRecord;

@Data
@Table(name = "environments")
public class Environment {

	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "metadata")
	private JsonNode metadata;
	private Lock lock;
	private Pool pool;

	public Environment(EnvironmentsRecord environmentsRecord, PoolsRecord poolsRecord) {
		this.id = environmentsRecord.getId();
		this.name = environmentsRecord.getName();
		this.metadata = environmentsRecord.getMetadata();
		this.pool = new Pool(poolsRecord);
	}

	public Environment(EnvironmentsRecord environmentsRecord, PoolsRecord poolsRecord, Lock lock) {
		this.id = environmentsRecord.getId();
		this.name = environmentsRecord.getName();
		this.metadata = environmentsRecord.getMetadata();
		this.pool = new Pool(poolsRecord);
		this.lock = lock;
	}

	public Environment() {

	}

	public Environment(EnvironmentsRecord environmentsRecord) {
	}
}
