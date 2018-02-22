package io.pivotal.spring.cloud.services.resourcelock.api;

import javax.validation.constraints.NotNull;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.pivotal.spring.cloud.services.resourcelock.model.Lock;


public class LockController {

	@RequestMapping(value = "/lock/findByEnvironmentName",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<Lock> findLockByEnvironmentName(@NotNull  @RequestParam(value = "envName", required = true) String envName) {
		// do some magic!
		return new ResponseEntity<Lock>(HttpStatus.OK);
	}


	@RequestMapping(value = "/lock/{lockId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<Lock> getLockById( @PathVariable("lockId") Integer lockId) {
		// do some magic!
		return new ResponseEntity<Lock>(HttpStatus.OK);
	}


	@RequestMapping(value = "/lock",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<List<Lock>> listLocks() {
		// do some magic!
		return new ResponseEntity<List<Lock>>(HttpStatus.OK);
	}
}
