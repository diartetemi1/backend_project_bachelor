package bachelor.kurierdienst.controller;

import java.util.*;
import bachelor.kurierdienst.dto.TripDto;
import bachelor.kurierdienst.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
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
import bachelor.kurierdienst.model.Trip;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class TripController {

	@Autowired
	private TripService tripService;

	@GetMapping("/trips")
	public ResponseEntity<List<Trip>> getTrips() {

		return ResponseEntity.ok(tripService.getAll());

	}

	@GetMapping("/trips/{jobNumber}")
	public ResponseEntity<Trip> getTripById(@PathVariable Integer jobNumber) {

		Trip trip = tripService.getById(jobNumber);
		if (trip == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(trip);

	}

	@PostMapping("/trips")
	public ResponseEntity<Trip> createTrip(@RequestBody TripDto tripDto) {

		//REQUEST BODY BEISPIEL FÜR POSTMAN
//		{
//				"datum": "2022-06-29",
//				"orderer": "orderer_test",
//				"startAdress": "adress_test",
//				"finishingPoint": "finishPint_test",
//				"fahrzeugart": "bus",
//				"entfernung": 400,
//				"serviceZeit": 57,
//				"nettoPreis": 560,
//				"customerId": 1,
//				"courierDriverId": 1
//		}

		Trip trip = tripService.create(tripDto);
		if(trip == null) return ResponseEntity.notFound().build();

		return ResponseEntity.ok(trip);

	}

	@PutMapping("/trips/{jobNumber}")
	public ResponseEntity<Trip> updateTrip(@PathVariable Integer jobNumber,
												 @RequestBody TripDto tripDto) {

		//REQUEST BODY BEISPIEL FÜR POSTMAN
//		{
//				"datum": "2022-06-29",
//				"orderer": "orderer_test",
//				"startAdress": "adress_test",
//				"finishingPoint": "finishPint_test",
//				"fahrzeugart": "bus",
//				"entfernung": 400,
//				"serviceZeit": 57,
//				"nettoPreis": 560,
//				"customerId": 1,
//				"courierDriverId": 1
//		}

		Trip trip = tripService.update(jobNumber, tripDto);
		if(trip == null) return ResponseEntity.notFound().build();

		return ResponseEntity.ok(trip);

	}

	@DeleteMapping("/trips/{jobNumber}")
	public ResponseEntity<Map<String, Boolean>> deleteTrip(@PathVariable Integer jobNumber) {

		boolean isDeleted = tripService.delete(jobNumber);
		if(!isDeleted) return ResponseEntity.notFound().build();

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}
