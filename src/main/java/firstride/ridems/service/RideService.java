package firstride.ridems.service;

import firstride.ridems.entity.RideEntity;
import firstride.ridems.repository.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    @Autowired
    RideRepo rideRepo;
    public ResponseEntity<RideEntity> createRide(RideEntity ride){
        return ResponseEntity.ok(rideRepo.save(ride));
    }
    public List<RideEntity> getAllRides() {
        return rideRepo.findAll();
    }
    public Optional<RideEntity> getRideById(Long id) {
        return rideRepo.findById(id);
    }
    public Optional<RideEntity> deleteRide(Long id){
        Optional<RideEntity> byId = rideRepo.findById(id);
        if (byId.isPresent())
        {
            rideRepo.delete(byId.get());
        }
        return byId;
    }
    public Optional<RideEntity> update(Long id, RideEntity ride){
        Optional<RideEntity> byId = rideRepo.findById(id);
        if(byId.isPresent())
        {
            RideEntity entity = byId.get();
            entity.setDate(ride.getDate());
            entity.setDriverid(ride.getDriverid());
            entity.setDestinaion(ride.getDestinaion());
            entity.setOrgin(ride.getOrgin());
            entity.setPrice(ride.getPrice());
            entity.setNumOfSeats(ride.getNumOfSeats());
        }
        return byId;
    }



}
