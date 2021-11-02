package com.example.demo.request;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceRequest {
    private User user;    //User Request
    private List<ProductRequest> products;  //List of products requests

}
