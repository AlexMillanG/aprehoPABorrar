package com.example.apreho.model.rolBean;
import com.example.apreho.model.userBean.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;
    @Column(length = 45, nullable = false)
    private String rolName;



    @OneToOne(mappedBy = "rol", cascade = CascadeType.ALL)
    private User user;

}
