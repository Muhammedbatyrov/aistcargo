package model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private Long imageId;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean hasSubscription;
    private String profileImage;

    @ManyToMany
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<Subscription> subscriptions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "delivery",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<Delivery> deliveries;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sendingPerson")
    private List<Sending> sendings;

}
