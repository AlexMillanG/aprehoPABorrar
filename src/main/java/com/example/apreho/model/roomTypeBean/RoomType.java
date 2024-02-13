package com.example.apreho.model.roomTypeBean;

import com.example.apreho.model.ratesBean.Rates;
import com.example.apreho.model.roomBean.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "roomType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomTypeId;
    @Column(length = 45, nullable = false)
    private String typeName;
    @Column(nullable = false)
    private  Double price;



    @OneToOne(mappedBy = "roomType", cascade = CascadeType.ALL)
    private Room room;

    @ManyToMany(mappedBy = "roomType")
    Set<Rates> rates;

}
