package com.example.apreho.model.paymentHistoryBean;

import com.example.apreho.model.productsBean.Products;
import com.example.apreho.model.reservationsBean.Reservations;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "paymentHistory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentHistoryId;
    private LocalDate checkout;
    @Column(nullable = false)
    private  Double total;
    @Column(nullable = false)
    private  Boolean paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservationId")
    private Reservations reservations;
}
