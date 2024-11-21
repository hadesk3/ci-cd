package com.tutorial.employeemanagmentbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.employeemanagmentbackend.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long>{
	   Optional<com.tutorial.employeemanagmentbackend.model.Booking> findByBookingConfirmationCode(String confirmationCode);
	   List<Booking> findByUserId(Long userId);
	   List<Booking> findByRoomId(Long id);
}
