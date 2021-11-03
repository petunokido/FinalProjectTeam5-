package com.example.demo.request;

import com.example.demo.model.Invoice;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private int id;
    private String userName;
    private int age;
    //private InvoiceRequest invoiceRequest;
}
