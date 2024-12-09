package model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.enums.PackageType;
import model.enums.Size;
import model.enums.TransportType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    private Long userId;

    private String fromWhere;
    private String toWhere;
    private LocalDate dispatchDate;
    private LocalDate arrivalDate;

    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @Enumerated(EnumType.STRING)
    private PackageType packageType;

    @Enumerated(EnumType.STRING)
    private Size size;

    private String travelDescription;

    @ManyToMany(mappedBy = "delivery", cascade = CascadeType.MERGE)
    private List<User> user;
}
