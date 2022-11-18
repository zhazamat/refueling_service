package com.example.refueling_service.models;

import com.example.refueling_service.models.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="client_and_fuel")
public class ClientAndFuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double volume;
    Double amount;
    Double change;
    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "client_id")
    Client client;
    @ManyToOne(targetEntity = Fuel.class)
    @JoinColumn(name = "fuel_id")
    Fuel fuel;
    String plateNumber;
    @Enumerated(value =EnumType.STRING )
    Status payStatus;
    @CreationTimestamp
    Date createdDate;




}
