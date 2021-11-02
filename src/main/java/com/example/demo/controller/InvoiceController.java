package com.example.demo.controller;


import com.example.demo.controller.request.InvoiceRQ;
import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

   //Get all Invoices
   @GetMapping("/invoices")
    public List<Invoice> getAllInvoices() {
       return invoiceService.getAllInvoice();}
    //Get Invoice by Id
    @GetMapping("/invoices/{id}")
    public Invoice getInvoiceById(int invoiceid) {
        return invoiceService.getInvoiceById(invoiceid);}
   //Create new Invoice
    @PutMapping("/invoices")
    public Invoice createInvoice(@RequestBody  InvoiceRQ invoice){
       return invoiceService.createInvoice(invoice);}

}
