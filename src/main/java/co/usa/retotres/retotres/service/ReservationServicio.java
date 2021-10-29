package co.usa.retotres.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retotres.retotres.model.Reservation;
import co.usa.retotres.retotres.repository.ReservationRepositorio;

@Service 
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;
    public List<Reservation>getALL(){
        return reservationRepositorio.getAll();
    }

   
    public Optional<Reservation>getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }

    public Reservation save(Reservation rsv){
        if(rsv.getIdReservation()==null){
            return reservationRepositorio.save(rsv);
        }else{
            Optional<Reservation> e= reservationRepositorio.getReservation(rsv.getIdReservation());
            if(e.isEmpty()){
                return reservationRepositorio.save(rsv);
            }else{
                return rsv;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepositorio.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepositorio.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepositorio.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

