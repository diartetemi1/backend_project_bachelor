package bachelor.kurierdienst.service;

import bachelor.kurierdienst.dto.CourierDriverDto;
import bachelor.kurierdienst.model.CourierDriver;
import bachelor.kurierdienst.repository.CourierDriverRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierDriverService {

    private final CourierDriverRepository courierDriverRepository;
    private final ModelMapper modelMapper;

    public List<CourierDriver> getAll() {
        return courierDriverRepository.findAll();
    }

    public CourierDriver getById(Integer driverNumber) {
        return courierDriverRepository.findById(driverNumber).orElse(null);
    }

    public CourierDriver create(CourierDriverDto courierDriverDto) {
        CourierDriver courierDriver = modelMapper.map(courierDriverDto, CourierDriver.class);
        courierDriver.setDriverID(null);
        return courierDriverRepository.save(courierDriver);
    }

    public CourierDriver update(Integer driverNumber, CourierDriverDto courierDriverDto) {
        Optional<CourierDriver> courierDriverOptional = courierDriverRepository.findById(driverNumber);
        if (courierDriverOptional.isEmpty()) {
            return null;
        }

        CourierDriver courierDriver = courierDriverOptional.get();
        modelMapper.map(courierDriverDto, courierDriver);

        return courierDriverRepository.save(courierDriver);
    }

    public boolean delete(Integer driverNumber) {
        Optional<CourierDriver> courierDriverOptional = courierDriverRepository.findById(driverNumber);
        if (courierDriverOptional.isEmpty()) {
            return false;
        }

        courierDriverRepository.deleteById(driverNumber);
        return true;
    }

}
