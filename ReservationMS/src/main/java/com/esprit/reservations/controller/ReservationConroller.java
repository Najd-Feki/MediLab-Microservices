package com.esprit.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.reservations.entity.Reservation;
import com.esprit.reservations.service.ReservationRestAPI;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/reservations")
public class ReservationConroller {
	
	@Autowired
	private ReservationRestAPI reservationRestAPI;

	

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Reservation>> getAeros(@RequestBody Reservation personnel) {
		return new ResponseEntity<>(reservationRestAPI.getAllReservation(), HttpStatus.OK);
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
		return new ResponseEntity<>(reservationRestAPI.addReservation(reservation), HttpStatus.OK);
	}
	
	@PutMapping(value = "/id")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "/id") int id, @RequestBody Reservation reservation){
		return new ResponseEntity<>(reservationRestAPI.updateReservation(id,reservation), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/id")
	@ResponseStatus(HttpStatus.OK)
	public void deleteReservation(@PathVariable(value = "/id") int id){
		reservationRestAPI.deleteReservation(id);
	}

}
