package com.aistcargo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String cardNumber;
    private LocalDateTime expiryDateOfCard;
    private String cvcCode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "subscription_id", unique = true)
    private Subscription subscription;

    public Payment(String userName, String cardNumber, LocalDateTime expiryDateOfCard, String cvcCode, User user, Subscription subscription) {
        this.userName = userName;
        this.cardNumber = cardNumber;
        this.expiryDateOfCard = expiryDateOfCard;
        this.cvcCode = cvcCode;
        this.user = user;
        this.subscription = subscription;
    }
}
