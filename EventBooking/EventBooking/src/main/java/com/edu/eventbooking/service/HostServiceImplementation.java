package com.edu.eventbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Host;
import com.edu.eventbooking.repository.HostRepository;

@Service
public class HostServiceImplementation implements HostService{

	@Autowired
	private HostRepository hostRepository;

	@Override
	public Host registerHost(Host host) {
		// TODO Auto-generated method stub
		return hostRepository.save(host);
	}
	
	@Override
	public List<Host> getAllHosts(){
		return hostRepository.findAll();
	}
}
