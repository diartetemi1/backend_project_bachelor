package bachelor.kurierdienst.controller;

import java.util.*;

import bachelor.kurierdienst.dto.CustomerDto;
import bachelor.kurierdienst.service.CustomerService;
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

import bachelor.kurierdienst.model.Customer;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {

		return ResponseEntity.ok(customerService.getAll());

	}

	@GetMapping("/customers/{customerNumber}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerNumber) {

		Customer customer = customerService.getById(customerNumber);
		if (customer == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);

	}
	
	@PostMapping("/customers")
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

	@PutMapping("/customers/{customerNumber}")
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
		if(customer == null) return ResponseEntity.notFound().build();

		return ResponseEntity.ok(customer);

	}

	@DeleteMapping("/customers/{customerNumber}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Integer customerNumber) {

		boolean isDeleted = customerService.delete(customerNumber);
		if(!isDeleted) return ResponseEntity.notFound().build();

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

	
}
