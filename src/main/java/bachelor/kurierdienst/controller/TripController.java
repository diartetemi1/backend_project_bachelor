package bachelor.kurierdienst.controller;

import bachelor.kurierdienst.dto.TripDto;
import bachelor.kurierdienst.model.Trip;
import bachelor.kurierdienst.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @GetMapping
    public ResponseEntity<List<Trip>> getTrips() {
        return ResponseEntity.ok(tripService.getAll());
    }

    @GetMapping("/{jobNumber}")
    public ResponseEntity<Trip> getTripById(@PathVariable Integer jobNumber) {
        Trip trip = tripService.getById(jobNumber);
        if (trip == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip);
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody TripDto tripDto) {
        Trip trip = tripService.create(tripDto);
        if (trip == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(trip);
    }

    @PutMapping("/{jobNumber}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Integer jobNumber,
                                           @RequestBody TripDto tripDto) {
        Trip trip = tripService.update(jobNumber, tripDto);
        if (trip == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(trip);
    }

    @DeleteMapping("/{jobNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteTrip(@PathVariable Integer jobNumber) {

        boolean isDeleted = tripService.delete(jobNumber);
        if (!isDeleted) return ResponseEntity.notFound().build();

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
