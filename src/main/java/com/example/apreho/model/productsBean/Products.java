package com.example.apreho.model.productsBean;

import com.example.apreho.model.hotelBean.Hotel;
import com.example.apreho.model.paymentHistoryBean.PaymentHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(length = 45, nullable = false)
    private String productName;
    @Column(nullable = false)
    private int price;
    @Column(length = 150, nullable = false)
    private String productDescription;
    @Column(nullable = false)
    private int quantity;

    @ManyToMany(mappedBy = "products")
    Set<Hotel> hotel;


    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PaymentHistory> paymentHistory;



}
