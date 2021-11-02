package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "invoice")

public class Invoice
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int number;


    @OneToMany(mappedBy = "invoice")
    private List<Product> product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
