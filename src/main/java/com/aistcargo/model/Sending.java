package com.aistcargo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sending")
public class Sending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sendingId;
    private String fromWhere;
    private String toWhere;
    private LocalDate dispatchDate;
    private LocalDate arrivalDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Sending(String fromWhere, String toWhere, LocalDate dispatchDate, LocalDate arrivalDate, User user) {
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
        this.dispatchDate = dispatchDate;
        this.arrivalDate = arrivalDate;
        this.user = user;
    }
}
