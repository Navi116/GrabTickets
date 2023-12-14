package com.edu.eventbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eventbooking.dao.Host;
import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.error.GlobalException;
import com.edu.eventbooking.service.HostService;
import com.edu.eventbooking.service.ShowsService;

@RestController
public class HostController {
	@Autowired
	private HostService hostService;
	
	@Autowired
	private ShowsService showsService;
	
	
	
	@PostMapping("registerHost")
	public Host registerHost(@RequestBody Host host) {
		return hostService.registerHost(host);
		
	}
	
	@GetMapping("/getAllHosts")
	public List<Host> getAllHosts(){
		return hostService.getAllHosts();
	}

	@PutMapping("/setShowToHost/{showid}/{hostid}")
	public Shows setShowToHost(@PathVariable("hostid") Integer hostid, @PathVariable("showid") Integer showid) throws GlobalException {
		return showsService.setShowToHost(hostid,showid);
	}


	@PutMapping("/updateShowName/{showname}/{hostid}")
	public Shows updateShowName(@PathVariable("showname") String showname, @PathVariable("hostid") Integer hostid) {
		
		return showsService.updateShowName(showname,hostid);
	}
	
	

	
}
