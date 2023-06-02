package com.ncc.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Registration_User_Token")
public class RegistrationUserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "token", length = 50, nullable = false, unique = true)
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;

    @Column(name = "expiryDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public RegistrationUserToken(String token, User user) {
        this.token = token;
        this.user = user;

        expiryDate = new Date(System.currentTimeMillis() + 360000);
    }
}
