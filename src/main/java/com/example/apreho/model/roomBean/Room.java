package com.example.apreho.model.roomBean;

import com.example.apreho.model.hotelBean.Hotel;
import com.example.apreho.model.imagesBean.Images;
import com.example.apreho.model.reservationsBean.Reservations;
import com.example.apreho.model.roomTypeBean.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Column(length = 45, nullable = false)
    private String status;
    @Column(nullable = false)
    private int peopleQuantity;
    @Column(length = 45, nullable = false)
    private String description;


    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservations> reservations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomTypeId")
    private RoomType roomType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imagesId")
    private Images images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
    private Hotel hotel;


}
