package com.nix.alenevskyi.rentauto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    UUID id;

    @Column(name = "place_of_filing")
    String placeOfFiling;

    @Column(name = "place_of_return")
    String placeOfReturn;

    @Column(name = "filing_time")
    Instant filingTime;

    @Column(name = "return_time")
    Instant returnTime;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;
}
