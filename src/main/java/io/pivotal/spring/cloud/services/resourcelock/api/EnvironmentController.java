package io.pivotal.spring.cloud.services.resourcelock.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import io.pivotal.spring.cloud.services.resourcelock.model.Pool;

@Controller
public class EnvironmentController {


	@RequestMapping(value = "/environment",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.POST)
	ResponseEntity<Pool> addPool(@Valid @RequestBody Pool body) {
		// do some magic!
		return new ResponseEntity<Pool>(HttpStatus.OK);
	}


	@RequestMapping(value = "/environment/{environmentId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.DELETE)
	ResponseEntity<Pool> deletePoolById(@PathVariable("environmentId") Integer environmentId) {
		// do some magic!
		return new ResponseEntity<Pool>(HttpStatus.OK);
	}


	@RequestMapping(value = "/environment/findByName",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<Pool> findPoolByName(@NotNull
										@RequestParam(value = "environmentName", required = true) String environmentName,
										@RequestParam(value = "withRelations", required = false, defaultValue = "false") Optional<Boolean> withRelations) {
		// do some magic!
		return new ResponseEntity<Pool>(HttpStatus.OK);
	}


	@RequestMapping(value = "/environment/{environmentId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<Pool> getPoolById(@PathVariable("environmentId") Integer environmentId,
									 Optional<Boolean> withRelations) {
		// do some magic!
		return new ResponseEntity<Pool>(HttpStatus.OK);
	}

	@RequestMapping(value = "/environment",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.GET)
	ResponseEntity<List<Pool>> listPools(@RequestParam(value = "withRelations", required = false, defaultValue = "false") Optional<Boolean> withRelations) {
		// do some magic!
		return new ResponseEntity<List<Pool>>(HttpStatus.OK);
	}


	@RequestMapping(value = "/environment/{environmentId}",
			produces = "application/json",
			consumes = "application/json",
			method = RequestMethod.PUT)
	ResponseEntity<Pool> updatePool(@PathVariable("environmentId") Integer environmentId,
									@Valid @RequestBody Pool body) {
		// do some magic!
		return new ResponseEntity<Pool>(HttpStatus.OK);
	}

}

