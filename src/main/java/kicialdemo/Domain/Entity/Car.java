package kicialdemo.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @NonNull
    private String brand;

    @NonNull
    private String registrationNumber;
}
