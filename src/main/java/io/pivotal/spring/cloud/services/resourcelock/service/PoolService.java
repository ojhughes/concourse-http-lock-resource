package io.pivotal.spring.cloud.services.resourcelock.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Pools;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.PoolsRecord;
import io.pivotal.spring.cloud.services.resourcelock.model.Environment;
import io.pivotal.spring.cloud.services.resourcelock.model.Lock;
import io.pivotal.spring.cloud.services.resourcelock.model.Pool;

@Service
@Slf4j
public class PoolService {

	private DSLContext dbContext;

	@Autowired
	public PoolService(DSLContext dbContext) {
		this.dbContext = dbContext;
	}

	@Transactional
	public Lock claimLock(String poolName) {
		return null;
	}

	@Transactional
	public Lock claimLockForEnvironment(String poolName, String environmentName) {
		return null;
	}

	@Transactional
	public Pool create(Pool body) {
		InsertResultStep<PoolsRecord> insertPoolStep = dbContext
				.insertInto(Pools.POOLS)
				.columns(Pools.POOLS.NAME)
				.values(body.getName())
				.returning(Pools.POOLS.ID, Pools.POOLS.NAME);
		log.info("Executing SQL: {}", insertPoolStep.getSQL());

		return new Pool(insertPoolStep.fetchOne());
	}

	@Transactional
	public void delete(int poolId) {

	}

	public Pool findById(int poolId) {
		return null;
	}

	public Pool findByName(String poolName) {
		return null;
	}

	public List<Environment> findUnclaimedEnvironments(String poolName) {
		return null;
	}

	public List<Pool> listPools() {

		return dbContext.selectFrom(Pools.POOLS)
									   .stream()
									   .map(Pool::new)
									   .collect(Collectors.toList());
	}

	@Transactional
	public Pool releaseEnvironment(String poolName, String environmentName) {
		return null;
	}

	@Transactional
	public Pool update(Integer poolId, Pool body) {
		return null;
	}
}

