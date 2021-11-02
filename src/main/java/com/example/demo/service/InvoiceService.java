package com.example.demo.service;


import com.example.demo.controller.request.InvoiceRQ;
import com.example.demo.exception.InvoiceNotFound;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public List<Invoice> getAllInvoice() {
        if (invoiceRepository.findAll().isEmpty()){
            throw new InvoiceNotFound("There are no stored invoices");
        }else{
        return invoiceRepository.findAll();}}
    public Invoice getInvoiceById(int invoiceid) {
        return invoiceRepository.findById(invoiceid).orElseThrow(() -> new InvoiceNotFound("The requested invoice doesn't exist"));}


    public Invoice createInvoice(InvoiceRQ invoice) {
        String username = invoice.getUser().getName();
        if (userRepository.findByName(username).isEmpty()){
            throw new UserNotFound("The specified user doesn't exist. Please created first.");
        } else{
            User user = userRepository.finByName(username);}    //Finds the user based on the request
        List<ProductRequest> listproductrq = invoice.getProducts(); //List with al the products requests
        List<Product> listproducts = new ArrayList<Product>();  //Empty list of requests to be populated with the products
        for(ProductRequest product:listproductrq){
            if(productRepository.findById(product.getId()).isEmpty()){
                throw new ProductNotFound("The product does not exist. Please created it first.");
            }else {
                Product newproduct = productRepository.findById(product.getId()).get();
                listproducts.add(newproduct);}}
        Invoice newinvoice = Invoice.builder().user(invoice.getUser()).product(listproducts).build();
        invoiceRepository.save(newinvoice);
        return newinvoice;
    }
}
