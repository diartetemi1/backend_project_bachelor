package bachelor.kurierdienst.controller;

import java.util.*;

import bachelor.kurierdienst.dto.InvoiceDto;
import bachelor.kurierdienst.service.InvoiceService;
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

import bachelor.kurierdienst.model.Invoice;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/invoices")
	public ResponseEntity<List<Invoice>> getInvoices() {

		return ResponseEntity.ok(invoiceService.getAll());

	}

	@GetMapping("/invoices/{invoiceNumber}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer invoiceNumber) {

		Invoice invoice = invoiceService.getById(invoiceNumber);
		if (invoice == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(invoice);

	}

	@PostMapping("/invoices")
	public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceDto invoiceDto) {

		//REQUEST BODY BEISPIEL FÜR POSTMAN

//		{
//				"datum": "2022-06-25",
//				"endBetrag": 450,
//				"customerId": 1,
//				"tripsIds": [1,2]
//		}

		Invoice invoice = invoiceService.create(invoiceDto);
		if(invoice == null) return ResponseEntity.notFound().build();

		return ResponseEntity.ok(invoice);

	}

	@PutMapping("/invoices/{invoiceNumber}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable Integer invoiceNumber,
												   @RequestBody InvoiceDto invoiceDto) {

		//REQUEST BODY BEISPIEL FÜR POSTMAN

//		{
//				"datum": "2022-06-25",
//				"endBetrag": 450,
//				"customerId": 1,
//				"tripsIds": [1,2]
//		}

		Invoice invoice = invoiceService.update(invoiceNumber, invoiceDto);
		if(invoice == null) return ResponseEntity.notFound().build();

		return ResponseEntity.ok(invoice);

	}

	@DeleteMapping("/invoices/{invoiceNumber}")
	public ResponseEntity<Map<String, Boolean>> deleteInvoice(@PathVariable Integer invoiceNumber) {

		boolean isDeleted = invoiceService.delete(invoiceNumber);
		if(!isDeleted) return ResponseEntity.notFound().build();

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}
