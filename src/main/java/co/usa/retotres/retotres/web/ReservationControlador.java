package co.usa.retotres.retotres.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.retotres.retotres.model.Reservation;
import co.usa.retotres.retotres.service.ReservationServicio;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ReservationControlador {
    @Autowired
    private ReservationServicio reservationServicio;
    @GetMapping("/all")
    public List<Reservation>getReservations(){
        return reservationServicio.getALL();
    }

    @GetMapping("/{idReservation}")
    
    public Optional<Reservation>getReservation(@PathVariable("idReservation")int id){
        return reservationServicio.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation rsv){
        return reservationServicio.save(rsv);
    }
        
}
