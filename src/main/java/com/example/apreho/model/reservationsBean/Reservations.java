package com.example.apreho.model.reservationsBean;

import com.example.apreho.model.paymentHistoryBean.PaymentHistory;
import com.example.apreho.model.peopleBean.People;
import com.example.apreho.model.roomBean.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @Column(columnDefinition = "DATE",nullable = false)
    private LocalDate checkin;
    @Column(columnDefinition = "DATE",nullable = false)
    private LocalDate checkout;
    @Column(nullable = false)
    private  Double discountQuantity;
    @Column(nullable = false)
    private  Boolean discount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peopleId")
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

    @OneToMany(mappedBy = "reservations", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PaymentHistory> paymentHistory;



}
