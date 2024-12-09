package model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.enums.PackageType;
import model.enums.Size;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Sending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sendingId;

    private String fromWhere;
    private String toWhere;
    private LocalDate dispatchDate;
    private LocalDate arrivalDate;
    @Enumerated(EnumType.STRING)
    private PackageType packageType;
    @Enumerated(EnumType.STRING)
    private Size size;
    private String travelDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
