package com.aistcargo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;
    private Double price;
    private LocalDate subscribedDate;
    private LocalDate subscriptionEndDate;

    @ManyToMany(mappedBy = "subscriptions")
    private List<User> user;

    @OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL)
    private Payment payment;

    public Subscription(Double price, LocalDate subscribedDate, LocalDate subscriptionEndDate, List<User> user, Payment payment) {
        this.price = price;
        this.subscribedDate = subscribedDate;
        this.subscriptionEndDate = subscriptionEndDate;
        this.user = user;
        this.payment = payment;
    }
}
