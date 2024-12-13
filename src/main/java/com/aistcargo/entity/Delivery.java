package com.aistcargo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    private String fromWhere;
    private String toWhere;
    private LocalDate dispatchDate;
    private LocalDate arrivalDate;
    private String travelDescription;

    @ManyToMany(mappedBy = "deliveries")
    private List<User> user;

    public Delivery(String fromWhere, String toWhere, LocalDate dispatchDate, LocalDate arrivalDate, String travelDescription, List<User> user) {
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
        this.dispatchDate = dispatchDate;
        this.arrivalDate = arrivalDate;
        this.travelDescription = travelDescription;
        this.user = user;
    }
}
