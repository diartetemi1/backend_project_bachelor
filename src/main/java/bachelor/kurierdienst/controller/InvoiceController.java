package bachelor.kurierdienst.controller;

import bachelor.kurierdienst.dto.InvoiceDto;
import bachelor.kurierdienst.model.Invoice;
import bachelor.kurierdienst.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getInvoices() {

        return ResponseEntity.ok(invoiceService.getAll());

    }

    @GetMapping("/{invoiceNumber}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer invoiceNumber) {

        Invoice invoice = invoiceService.getById(invoiceNumber);
        if (invoice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(invoice);

    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceDto invoiceDto) {

        //REQUEST BODY BEISPIEL FÜR POSTMAN

//		{
//				"datum": "2022-06-25",
//				"endBetrag": 450,
//				"customerId": 1,
//				"tripsIds": [1,2]
//		}

        Invoice invoice = invoiceService.create(invoiceDto);
        if (invoice == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(invoice);

    }

    @PutMapping("/{invoiceNumber}")
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
        if (invoice == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(invoice);

    }

    @DeleteMapping("/{invoiceNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteInvoice(@PathVariable Integer invoiceNumber) {

        boolean isDeleted = invoiceService.delete(invoiceNumber);
        if (!isDeleted) return ResponseEntity.notFound().build();

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
