package io.pivotal.spring.cloud.services.resourcelock.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.pivotal.spring.cloud.services.resourcelock.model.Environment;
import io.pivotal.spring.cloud.services.resourcelock.model.Lock;
import io.pivotal.spring.cloud.services.resourcelock.model.Pool;
import io.pivotal.spring.cloud.services.resourcelock.service.PoolService;

@Controller
public class PoolController {

	private PoolService poolService;

	@Autowired
	public PoolController(PoolService poolService) {
		this.poolService = poolService;
	}

	@RequestMapping(value = "/pool",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.POST)
	ResponseEntity<Pool>createPool(@Valid @RequestBody Pool body) {
		Pool pool = poolService.create(body);
		return new ResponseEntity<>(pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolName}/claim/",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.PUT)
	ResponseEntity<Lock>claimEnvironment(@NotNull  @RequestParam(value = "poolName") String poolName) {
		Lock claimedLock = poolService.claimLock(poolName);
		return new ResponseEntity<>(claimedLock, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolName}/claim/{environmentName}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.PUT)
	ResponseEntity<Lock>claimNamedEnvironment(@NotNull  @RequestParam(value = "poolName") String poolName,
											  @NotNull @RequestParam(value = "environmentName") String environmentName) {
		Lock claimedLock = poolService.claimLockForEnvironment(poolName, environmentName);
		return new ResponseEntity<>(claimedLock, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.DELETE)
	ResponseEntity<Pool>deletePoolById( @PathVariable("poolId") int poolId) {
		poolService.delete(poolId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/findByName",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<Pool>findPoolByName(@NotNull  @RequestParam(value = "poolName") String poolName) {
		Pool pool = poolService.findByName(poolName);
		return new ResponseEntity<>(pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolName}/findUnclaimedEnvironments",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<List<Environment>> findUnclaimedEnvironments(@NotNull  @RequestParam(value = "poolName") String poolName) {
		List<Environment> environments = poolService.findUnclaimedEnvironments(poolName);
		return new ResponseEntity<>(environments, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<Pool>getPoolById(@PathVariable(value = "poolId") int poolId) {
		Pool pool = poolService.findById(poolId);
		return new ResponseEntity<>(pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool",
			produces = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<List<Pool>>listPools() {
		List<Pool> pools = poolService.listPools();
		return new ResponseEntity<>(pools, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolName}/release/{environmentName}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.DELETE)
	ResponseEntity<Pool>releaseEnvironment(@NotNull @RequestParam(value = "poolName") String poolName,
										   @NotNull  @RequestParam(value = "environmentName") String environmentName) {
		Pool pool = poolService.releaseEnvironment(poolName, environmentName);
		return new ResponseEntity<>(pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/pool/{poolId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.PUT)
	ResponseEntity<Pool>updatePool( @PathVariable("poolId") Integer poolId,  @Valid @RequestBody Pool body) {
		Pool pool = poolService.update(poolId, body);
		return new ResponseEntity<>(pool, HttpStatus.OK);
	}
}
