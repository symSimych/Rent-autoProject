package com.nix.alenevskyi.rentauto.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Images")
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "id")
    UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "file_name")
    String fileName;

    @Column(name = "size")
    Long size;

    @Column(name = "content_type")
    String contentType;

    @Lob
    @Column(name = "bytes")
    byte[] bytes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    Car car;
}
