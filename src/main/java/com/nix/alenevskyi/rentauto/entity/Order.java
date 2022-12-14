package com.nix.alenevskyi.rentauto.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
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
    LocalDateTime filingTime;

    @Column(name = "return_time")
    LocalDateTime returnTime;

    @Column(name = "confirmed")
    Boolean confirmed;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @PrePersist
    public void setConfirmed() {
        confirmed = false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", placeOfFiling='" + placeOfFiling + '\'' +
                ", placeOfReturn='" + placeOfReturn + '\'' +
                ", filingTime=" + filingTime +
                ", returnTime=" + returnTime +
                ", confirmed=" + confirmed +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}
