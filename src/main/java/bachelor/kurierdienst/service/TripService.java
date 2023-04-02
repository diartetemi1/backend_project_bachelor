package bachelor.kurierdienst.service;

import bachelor.kurierdienst.dto.TripDto;
import bachelor.kurierdienst.model.CourierDriver;
import bachelor.kurierdienst.model.Customer;
import bachelor.kurierdienst.model.Trip;
import bachelor.kurierdienst.repository.CourierDriverRepository;
import bachelor.kurierdienst.repository.CustomerRepository;
import bachelor.kurierdienst.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final CustomerRepository customerRepository;
    private final CourierDriverRepository courierDriverRepository;
    private final ModelMapper modelMapper;

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public Trip getById(Integer jobNumber) {
        return tripRepository.findById(jobNumber).orElse(null);
    }

    public Trip create(TripDto tripDto) {

        Optional<Customer> customerOptional = customerRepository.findById(tripDto.getCustomerId());
        if (customerOptional.isEmpty()) return null;
        Optional<CourierDriver> courierDriverOptional = courierDriverRepository.findById(tripDto.getCourierDriverId());
        if (courierDriverOptional.isEmpty()) return null;

        Trip trip = modelMapper.map(tripDto, Trip.class);
        trip.setCustomer(customerOptional.get());
        trip.setCourierDriver(courierDriverOptional.get());
        trip.setJobID(null);
        return tripRepository.save(trip);

    }

    public Trip update(Integer jobNumber, TripDto tripDto) {

        Optional<Trip> tripOptional = tripRepository.findById(jobNumber);
        if (tripOptional.isEmpty()) return null;

        Trip trip = tripOptional.get();
        Integer currentTripId = trip.getJobID();

        if (tripDto.getCustomerId() != null) {
            Optional<Customer> customerOptional = customerRepository.findById(tripDto.getCustomerId());
            if (customerOptional.isEmpty()) return null;
            trip.setCustomer(customerOptional.get());
        }
        if (tripDto.getCourierDriverId() != null) {
            Optional<CourierDriver> courierDriverOptional = courierDriverRepository.findById(tripDto.getCourierDriverId());
            if (courierDriverOptional.isEmpty()) return null;
            trip.setCourierDriver(courierDriverOptional.get());
        }

        modelMapper.map(tripDto, trip);
        trip.setJobID(currentTripId);
        return tripRepository.save(trip);

    }

    public boolean delete(Integer jobNumber) {

        Optional<Trip> tripOptional = tripRepository.findById(jobNumber);
        if (tripOptional.isEmpty()) {
            return false;
        }

        tripRepository.deleteById(jobNumber);
        return true;

    }

}
