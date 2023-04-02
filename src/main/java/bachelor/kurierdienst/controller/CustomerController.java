package bachelor.kurierdienst.controller;

import bachelor.kurierdienst.dto.CustomerDto;
import bachelor.kurierdienst.model.Customer;
import bachelor.kurierdienst.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {

        return ResponseEntity.ok(customerService.getAll());

    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerNumber) {

        Customer customer = customerService.getById(customerNumber);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);

    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) {

        //REQUEST BODY BEISPIEL FÜR POSTMAN

        //{
        //        "name" : "cust_test",
        //        "email" : "mail_test",
        //        "address" : "address_test",
        //        "city" : "city_test",
        //        "postalCode" : "postal_test",
        //        "country" : "country_test"
        //}

        return ResponseEntity.ok(customerService.create(customerDto));

    }

    @PutMapping("/{customerNumber}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerNumber,
                                                   @RequestBody CustomerDto customerDto) {

        //REQUEST BODY BEISPIEL FÜR POSTMAN

        //{
        //        "name" : "cust_test",
        //        "email" : "mail_test",
        //        "address" : "address_test",
        //        "city" : "city_test",
        //        "postalCode" : "postal_test",
        //        "country" : "country_test"
        //}

        Customer customer = customerService.update(customerNumber, customerDto);
        if (customer == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(customer);

    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Integer customerNumber) {

        boolean isDeleted = customerService.delete(customerNumber);
        if (!isDeleted) return ResponseEntity.notFound().build();

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }


}
