package bachelor.kurierdienst.controller;

import bachelor.kurierdienst.dto.CourierDriverDto;
import bachelor.kurierdienst.model.CourierDriver;
import bachelor.kurierdienst.service.CourierDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (courierDriver == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courierDriver);
    }

    @PostMapping
    public ResponseEntity<CourierDriver> createCourierDriver(@RequestBody CourierDriverDto CourierDriverDto) {
        return ResponseEntity.ok(courierDriverService.create(CourierDriverDto));
    }

    @PutMapping("/{driverNumber}")
    public ResponseEntity<CourierDriver> updateCourierDriver(@PathVariable Integer driverNumber,
                                                             @RequestBody CourierDriverDto courierDriverDto) {
        CourierDriver courierDriver = courierDriverService.update(driverNumber, courierDriverDto);
        if (courierDriver == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(courierDriver);
    }

    @DeleteMapping("/{driverNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteCourierDriver(@PathVariable Integer driverNumber) {

        boolean isDeleted = courierDriverService.delete(driverNumber);
        if (!isDeleted) return ResponseEntity.notFound().build();

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
