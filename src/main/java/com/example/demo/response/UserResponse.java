package com.example.demo.response;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse
{
    private int id;
    private String userName;
    private int age;
    //private List<Invoice> invoiceRequest;

public UserResponse userResponseResponse (User user)
{
    this.id = user.getId();
    this.userName = user.getUserName();
    this.age = user.getAge();
    //this.invoiceRequest= user.getInvoice();
    return this;
}
}
