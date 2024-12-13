package com.aistcargo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private Boolean hasSubscription;
    private String profileImage;

    @ManyToMany
    private List<Subscription> subscriptions;

    @ManyToMany
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sending> sendings;

    public User(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, String email, Boolean hasSubscription, String profileImage, List<Subscription> subscriptions, List<Delivery> deliveries, List<Sending> sendings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hasSubscription = hasSubscription;
        this.profileImage = profileImage;
        this.subscriptions = subscriptions;
        this.deliveries = deliveries;
        this.sendings = sendings;
    }
}
