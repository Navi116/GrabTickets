package com.edu.eventbooking.service;

import java.util.List;

import com.edu.eventbooking.dao.Host;

public interface HostService {

	public Host registerHost(Host host);

	public List<Host> getAllHosts();

}
