package com.edu.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer>{

}
