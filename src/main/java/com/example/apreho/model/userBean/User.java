package com.example.apreho.model.userBean;

import com.example.apreho.model.hotelBean.Hotel;
import com.example.apreho.model.peopleBean.People;
import com.example.apreho.model.rolBean.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(length = 45, nullable = false)
    private String username;
    @Column(length = 45, nullable = false)
    private String password;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rolId")
    private Rol rol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "peopleId")
    private People people;

    @ManyToMany(mappedBy = "user")
    Set<Hotel> hotel;

}
