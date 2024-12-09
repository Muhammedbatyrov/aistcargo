package model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    private Double price;
    private LocalDate subscribedDate;
    private LocalDate subscriptionEndDate;

    @ManyToMany(mappedBy = "subscriptions")
    private List<User> user;
}
