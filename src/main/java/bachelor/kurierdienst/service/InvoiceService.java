package bachelor.kurierdienst.service;

import bachelor.kurierdienst.dto.InvoiceDto;
import bachelor.kurierdienst.model.Customer;
import bachelor.kurierdienst.model.Invoice;
import bachelor.kurierdienst.model.Trip;
import bachelor.kurierdienst.repository.CustomerRepository;
import bachelor.kurierdienst.repository.InvoiceRepository;
import bachelor.kurierdienst.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final TripRepository tripRepository;
    private final ModelMapper modelMapper;


    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }

    public Invoice getById(Integer invoiceNumber){

        return invoiceRepository.findById(invoiceNumber).orElse(null);

    }

    public Invoice create(InvoiceDto invoiceDto){

        Optional<Customer> customerOptional = customerRepository.findById(invoiceDto.getCustomerId());
        if(!customerOptional.isPresent())return null;
        if(invoiceDto.getTripsIds() == null)return null;

        Integer[] tripsIds = invoiceDto.getTripsIds();
        List<Trip> trips = new ArrayList<>();

        Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);
        invoice.setCustomer(customerOptional.get());
        invoice.setInvoiceID(null);
        invoiceRepository.save(invoice);

        for (int i = 0; i < tripsIds.length; i++){
          Optional<Trip> tripOptional = tripRepository.findById(tripsIds[i]);
          if(!tripOptional.isPresent())return null;
          if(tripOptional.get().getCustomer().getCustomerID() != invoiceDto.getCustomerId()) return null;
          Trip trip = tripOptional.get();
          trip.setInvoice(invoice);
          trips.add(trip);
        }

        invoice.setTrips(trips);
        return invoiceRepository.save(invoice);

    }

    public Invoice update(Integer invoiceNumber, InvoiceDto invoiceDto){

        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceNumber);
        if(!invoiceOptional.isPresent()){
            return null;
        }
        Invoice invoice = invoiceOptional.get();
        Integer currentInvoiceId = invoice.getInvoiceID();
        boolean editCustomer = false;

        if(invoiceDto.getCustomerId() != null){
            Optional<Customer> customerOptional = customerRepository.findById(invoiceDto.getCustomerId());
            if(!customerOptional.isPresent())return null;
            invoice.setCustomer(customerOptional.get());
            editCustomer = true;
        }

        if(invoiceDto.getTripsIds() != null){

            invoice.getTrips().stream().forEach(t->{
                t.setInvoice(null);
                tripRepository.save(t);
            });

            modelMapper.map(invoiceDto, invoice);
            invoice.setInvoiceID(currentInvoiceId);

            Integer[] tripsIds = invoiceDto.getTripsIds();
            List<Trip> trips = new ArrayList<>();

            for (int i = 0; i < tripsIds.length; i++){
                Optional<Trip> tripOptional = tripRepository.findById(tripsIds[i]);
                if(!tripOptional.isPresent())return null;
                if(tripOptional.get().getCustomer().getCustomerID() != invoice.getCustomer().getCustomerID()) return null;
                Trip trip = tripOptional.get();
                trip.setInvoice(invoice);
                trips.add(tripOptional.get());
            }
            invoice.setTrips(trips);
        }else{
            modelMapper.map(invoiceDto, invoice);
            invoice.setInvoiceID(currentInvoiceId);
            if(editCustomer){
                List<Trip> trips = invoice.getTrips();
                for (int i = 0; i<trips.size(); i++){
                    if(trips.get(i).getCustomer().getCustomerID() != invoice.getCustomer().getCustomerID()) return null;
                }
            }
        }
        return invoiceRepository.save(invoice);

    }

    public boolean delete(Integer invoiceNumber){

        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceNumber);
        if(!invoiceOptional.isPresent()){
            return false;
        }
        Invoice invoice = invoiceOptional.get();
        invoice.getTrips().stream().forEach(t->{
            t.setInvoice(null);
            tripRepository.save(t);
        });
        invoiceRepository.deleteById(invoiceNumber);
        return true;

    }

}
