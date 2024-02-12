package mx.edu.utex.APREHO.model.roomBean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utex.APREHO.model.hotelBean.Hotel;
import mx.edu.utex.APREHO.model.imagesBean.Images;
import mx.edu.utex.APREHO.model.reservationsBean.Reservations;
import mx.edu.utex.APREHO.model.rolBean.Rol;
import mx.edu.utex.APREHO.model.roomTypeBean.RoomType;

import java.awt.*;
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
