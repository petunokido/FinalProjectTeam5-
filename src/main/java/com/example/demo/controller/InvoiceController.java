package com.example.demo.controller;


import com.example.demo.request.InvoiceRequest;
import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

   //Get all Invoices
   @ApiOperation(value = "Update registration detail",
           authorizations = { @Authorization(value="basicAuth") })
   @GetMapping("/invoices")
    public List<Invoice> getAllInvoices() {
       return invoiceService.getAllInvoice();}

    //Get Invoice by Id
    @ApiOperation(value = "Update registration detail",
            authorizations = { @Authorization(value="basicAuth") })
    @GetMapping("/invoices/{id}")
    public Invoice getInvoiceById(int invoiceid) {
        return invoiceService.getInvoiceById(invoiceid);}

   //Create new Invoice
   @ApiOperation(value = "Update registration detail",
           authorizations = { @Authorization(value="basicAuth") })
    @PutMapping("/invoices")
    public Invoice createInvoice(@RequestBody InvoiceRequest invoice){
       return invoiceService.createInvoice(invoice);}

}
