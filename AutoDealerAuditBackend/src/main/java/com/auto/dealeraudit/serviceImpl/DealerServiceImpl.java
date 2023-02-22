package com.auto.dealeraudit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.entity.Dealer;
import com.auto.dealeraudit.entity.DealerAddress;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.DealerAddressRepository;
import com.auto.dealeraudit.repository.DealerRepository;
import com.auto.dealeraudit.service.DealerService;

@Service
public class DealerServiceImpl implements DealerService {
	
	@Autowired
	DealerRepository dealerRepository;
	
	@Autowired
	DealerAddressRepository dealerAddressRepository;
	
	/* ********* ------------------- CREATE ---------------- *******************  */

	@Override
	public Dealer createDealer(Dealer dealer) throws CustomException {
		if(dealerRepository.findByDealerCode(dealer.getDealerCode()) == null) {
			return dealerRepository.save(dealer);
		} else {
			throw new CustomException("dealer with this Id already Exists");
		}
		
	}
	
	public DealerAddress createDealerAddress(DealerAddress dealerAddress) throws CustomException{
		//System.out.println(dealerAddressRepository.findById(dealerAddress.getDealerAddressId())== null);
		if(dealerAddressRepository.findById(dealerAddress.getDealerAddressId()).isEmpty()) {
			return dealerAddressRepository.save(dealerAddress);
		} else {
			throw new CustomException("dealer address with this Id already Exists");
		}
	}
	
	/* ********* ------------------- READ ---------------- *******************  */

	@Override
	public List<Dealer> getAllDealers() throws CustomException {
		if(dealerRepository.findAll().size() > 0) {
			return dealerRepository.findAll();
		} else {
			throw new CustomException("No Dealers Found");
		}
		
	}

	@Override
	public Dealer getDealerById(int dealerId) throws CustomException {
		if(dealerRepository.findById(dealerId).get() != null) {
			return dealerRepository.findById(dealerId).get();
		} else {
			throw new CustomException("Dealer with the given Id "+ dealerId + " does not exist.");
		}
		
	}
	
	public DealerAddress getDealerAddress(int addressId) throws CustomException{
		if(dealerAddressRepository.findById(addressId).get() != null) {
			return dealerAddressRepository.findById(addressId).get();
		} else {
			throw new CustomException("Dealer Address with the given Id "+ addressId + " does not exist.");
		}
	}
	/* ********* ------------------- UPDATE ---------------- *******************  */

	@Override
	public Dealer updateDealer(Dealer dealer) throws CustomException {
		
		if(dealerRepository.findById(dealer.getDealerId()) != null) {
			return dealerRepository.save(dealer);
		} else {
			throw new CustomException("dealer with this Id does not Exists");
		}
	}
	
	public DealerAddress updateDealerAddress(DealerAddress dealerAddress) throws CustomException{
		if(dealerAddressRepository.findById(dealerAddress.getDealerAddressId()) != null) {
			return dealerAddressRepository.save(dealerAddress);
		} else {
			throw new CustomException("dealer address with this Id does not Exists");
		}
	}
	
	/* ********* ------------------- DELETE ---------------- *******************  */

	@Override
	public String deleteDealerById(int dealerId) throws CustomException {
		if(dealerRepository.findById(dealerId).get() != null) {
			dealerRepository.deleteById(dealerId);
			return "Dealer with dealerId "+ dealerId + " deleted successfully";
		}else {
			throw new CustomException("dealer with this Id does not Exists");
		}
		
	}

}
