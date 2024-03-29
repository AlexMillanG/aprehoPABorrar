package com.example.apreho.model.hotelBean;

import com.example.apreho.model.imagesBean.Images;
import com.example.apreho.model.productsBean.Products;
import com.example.apreho.model.roomBean.Room;
import com.example.apreho.model.userBean.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;
    @Column(length = 45, nullable = false)
    private String hotelName;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private int phone;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> room;

    @ManyToMany
    @JoinTable(name = "hoteluser",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "hotelId"))
    Set<User> user = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imagesId")
    private Images images;


    @ManyToMany
    @JoinTable(name = "hotelproducts",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "hotelId"))
    Set<Products> products = new HashSet<>();


}
