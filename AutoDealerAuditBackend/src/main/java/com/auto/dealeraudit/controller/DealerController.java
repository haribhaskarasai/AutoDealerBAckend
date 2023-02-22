package com.auto.dealeraudit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auto.dealeraudit.entity.Dealer;
import com.auto.dealeraudit.entity.DealerAddress;
import com.auto.dealeraudit.service.DealerService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("stgit.com/autodealerauditappapi/dealer/v1")
public class DealerController {
	@Autowired
	DealerService dealerService;
	                       
	/* ********* ------------------- CREATE ---------------- *******************  */
	@PostMapping(value="dealer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dealerService.createDealer(dealer));
	}
	
	@PostMapping(value="dealersaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DealerAddress> createDealerAddress(@RequestBody DealerAddress dealerAddress) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dealerService.createDealerAddress(dealerAddress));
	}
	
	
	/* ********* ------------------- READ ---------------- *******************  */
	
	@GetMapping(value = "dealers")
	public List<Dealer> getAllDealers(){
		return dealerService.getAllDealers();
	}
	
	@GetMapping(value = "dealers/{dealerCode}")
	public ResponseEntity<Dealer> getDealerById(@PathVariable int dealerCode) {
		return ResponseEntity.status(HttpStatus.OK).body(dealerService.getDealerById(dealerCode));
	}
	
	@GetMapping(value = "dealersaddress/{addressId}")
	public ResponseEntity<DealerAddress> getDealerAddress(@PathVariable int addressId) {
		return ResponseEntity.status(HttpStatus.FOUND).body(dealerService.getDealerAddress(addressId));
	}
	
	/* ********* ------------------- UPDATE ---------------- *******************  */
	@PutMapping(value = "dealers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dealer> updateDealer(@RequestBody Dealer dealer) {
		return ResponseEntity.status(HttpStatus.OK).body(dealerService.updateDealer(dealer));
	}
	
	@PutMapping(value = "dealersaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DealerAddress> updateDealerAddress(@RequestBody DealerAddress dealerAddress) {
		return ResponseEntity.status(HttpStatus.OK).body(dealerService.updateDealerAddress(dealerAddress));
	}
	
	
	/* ********* ------------------- DELETE ---------------- *******************  */
	@DeleteMapping(value="dealers")
	public ResponseEntity<String> deleteDealerByCode(@RequestParam int dealerCode) {
		return ResponseEntity.status(HttpStatus.OK).body(dealerService.deleteDealerById(dealerCode));
	}
}
