package com.example.apreho.model.peopleBean;

import com.example.apreho.model.reservationsBean.Reservations;
import com.example.apreho.model.userBean.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Entity
@Table(name = "people")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long peopleId;
    @Column(length = 45, nullable = false)
    private String name;
    @Column(length = 45, nullable = false)
    private String lastname;
    @Column(length = 18, nullable = false)
    private String curp;



    @OneToOne(mappedBy = "people", cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "people", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservations> reservations;
}
