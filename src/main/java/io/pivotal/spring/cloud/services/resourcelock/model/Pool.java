package io.pivotal.spring.cloud.services.resourcelock.model;

import javax.persistence.Column;

import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.EnvironmentsRecord;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.PoolsRecord;

@Data
@NoArgsConstructor
public class Pool {
	@JsonProperty
	@Column(insertable = false, updatable = false)
	private Integer id;

	@JsonProperty
	@Column
	private String name;

	@JsonProperty
	@Column(insertable = false, updatable = false)
	private Set<Environment> environments;

	public Pool(PoolsRecord poolsRecord) {
		this.id = poolsRecord.getId();
		this.name = poolsRecord.getName();
	}

	public Pool(PoolsRecord poolsRecord, Set<EnvironmentsRecord> environmentsRecord) {
		this.id = poolsRecord.getId();
		this.name = poolsRecord.getName();
		this.environments = environmentsRecord.stream()
											  .map(env -> new Environment(env, poolsRecord))
											  .collect(Collectors.toSet());
	}
}
