package com.example.demo.service;


import com.example.demo.request.InvoiceRequest;
import com.example.demo.exception.InvoiceNotFound;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.ProductRequest;
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


    public Invoice createInvoice(InvoiceRequest invoice) {
        String username = invoice.getUser().getUsername();
        if (userRepository.getUserByUserName(username).isEmpty()){
            throw new UserNotFound("The specified user doesn't exist. Please created first.");
        } else{
            User user = userRepository.getUserByUserName(username).get();}    //Finds the user based on the request
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
