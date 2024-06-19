package firstride.ridems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class RideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orgin;
    private Double longitudeOrigin;
    private Double latitudeOrigin;

    private String destinaion;
    private Double longitudeDestination;
    private Double latitudeDestination;

    private Long price;
    private LocalDate date;
    private Integer numOfSeats;
    private long driverid;
}
