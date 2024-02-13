package com.example.apreho.model.imagesBean;

import com.example.apreho.model.hotelBean.Hotel;
import com.example.apreho.model.roomBean.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imagesId;
    @Column(nullable = false,columnDefinition = "BLOB")
    private byte[] image;


    @OneToMany(mappedBy = "images", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> room;

    @OneToMany(mappedBy = "images", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hotel> hotel;
}

