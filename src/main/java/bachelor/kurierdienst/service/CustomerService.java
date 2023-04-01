package bachelor.kurierdienst.service;

import bachelor.kurierdienst.dto.CustomerDto;
import bachelor.kurierdienst.model.Customer;
import bachelor.kurierdienst.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getById(Integer customerNumber){

        return customerRepository.findById(customerNumber).orElse(null);

    }

    public Customer create(CustomerDto customerDto){

        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setCustomerID(null);
        return customerRepository.save(customer);

    }

    public Customer update(Integer customerNumber, CustomerDto customerDto){

        Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
        if(!customerOptional.isPresent()){
            return null;
        }

        Customer customer = customerOptional.get();
        modelMapper.map(customerDto, customer);

        return customerRepository.save(customer);

    }

    public boolean delete(Integer customerNumber){

        Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
        if(!customerOptional.isPresent()){
            return false;
        }

        customerRepository.deleteById(customerNumber);
        return true;

    }
}
