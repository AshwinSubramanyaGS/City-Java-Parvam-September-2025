package com.gamingclub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private Double balance = 0.0;

    @Column(name = "membership_type")
    private String membershipType = "REGULAR";

    @Column(name = "total_games_played")
    private Integer totalGamesPlayed = 0;

    // Remove bidirectional mappings to avoid circular dependencies
    // @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    // private List<RechargeHistory> rechargeHistory = new ArrayList<>();

    // @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    // private List<PlayHistory> playHistory = new ArrayList<>();

    // Constructors
    public Member() {}

    public Member(String name, String phone, Double balance) {
        this.name = name;
        this.phone = phone;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public Integer getTotalGamesPlayed() { return totalGamesPlayed; }
    public void setTotalGamesPlayed(Integer totalGamesPlayed) { this.totalGamesPlayed = totalGamesPlayed; }
}