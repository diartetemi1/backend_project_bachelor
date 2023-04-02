package bachelor.kurierdienst.controller;

import java.util.*;

import bachelor.kurierdienst.dto.CourierDriverDto;
import bachelor.kurierdienst.model.CourierDriver;
import bachelor.kurierdienst.service.CourierDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class CourierDriverController {

	private final CourierDriverService courierDriverService;

	@GetMapping
	public ResponseEntity<List<CourierDriver>> getCourierDrivers() {

		return ResponseEntity.ok(courierDriverService.getAll());

	}

	@GetMapping("/{driverNumber}")
	public ResponseEntity<CourierDriver> getCourierDriverById(@PathVariable Integer driverNumber) {

		CourierDriver courierDriver = courierDriverService.getById(driverNumber);
		if (courierDriver == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(courierDriver);

	}

	@PostMapping
	public ResponseEntity<CourierDriver> createCourierDriver(@RequestBody CourierDriverDto CourierDriverDto) {

				//REQUEST BODY BEISPIEL FÜR POSTMAN

//		{
//				"firstName" : "driver_test",
//				"lastName" : "driver_test",
//				"email" : "email_test",
//				"phoneNumber" : "0123456789"
//		}

		return ResponseEntity.ok(courierDriverService.create(CourierDriverDto));

	}

	@PutMapping("/{driverNumber}")
	public ResponseEntity<CourierDriver> updateCourierDriver(@PathVariable Integer driverNumber,
												   @RequestBody CourierDriverDto courierDriverDto) {

		//REQUEST BODY BEISPIEL FÜR POSTMAN

//		{
//				"firstName" : "driver_test",
//				"lastName" : "driver_test",
//				"email" : "email_test",
//				"phoneNumber" : "0123456789"
//		}

		CourierDriver courierDriver = courierDriverService.update(driverNumber, courierDriverDto);
		if(courierDriver == null) return ResponseEntity.notFound().build();

		return ResponseEntity.ok(courierDriver);

	}

	@DeleteMapping("/{driverNumber}")
	public ResponseEntity<Map<String, Boolean>> deleteCourierDriver(@PathVariable Integer driverNumber) {

		boolean isDeleted = courierDriverService.delete(driverNumber);
		if(!isDeleted) return ResponseEntity.notFound().build();

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}


}
