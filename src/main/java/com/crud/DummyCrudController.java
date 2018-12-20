package com.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyCrudController {

	private static Map<String, Employee> dummyEmployeeMap = new HashMap<>();

	@PostMapping(value = "/subscribe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loadEmployeeData(@RequestBody List<Employee> empList) {
		for (Employee emp : empList) {
			dummyEmployeeMap.put(emp.getId(), emp);
		}
		return new ResponseEntity<String>(dummyEmployeeMap.toString(), HttpStatus.OK);
	}

	@GetMapping("/size")
	public int getMapSize() {
		return dummyEmployeeMap.size();
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getAllData() {
		return dummyEmployeeMap.toString();
	}

	@PostMapping(value = "/unsubscribe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String removeEmployeeFromMap(@RequestBody String id) {

		Object data = dummyEmployeeMap.remove(id);
		if (data == null) {
			return id + " unsubscribed failed !!!";
		}
		return id + " unsubscribed successfully !!!";
	}

}

/*
 * [
 * 
 * { "id":"123", "name":"sandeep", "companyName":"CTLI", "location":"BLR" } , {
 * "id":"1", "name":"sandeep kumar sahoo", "companyName":"IBM", "location":"BLR"
 * }
 * 
 * 
 * ]
 */
