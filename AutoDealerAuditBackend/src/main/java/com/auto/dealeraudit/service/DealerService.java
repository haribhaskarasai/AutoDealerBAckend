package com.auto.dealeraudit.service;

import java.util.List;

import com.auto.dealeraudit.entity.Dealer;
import com.auto.dealeraudit.entity.DealerAddress;
import com.auto.dealeraudit.exception.CustomException;

public interface DealerService {
	
/* ------------------- CREATE ----------------   */
	
	public abstract Dealer createDealer(Dealer dealer) throws CustomException ;
	
	public abstract DealerAddress createDealerAddress(DealerAddress dealerAddress) throws CustomException ;
	
	
	/* ------------------- READ ----------------   */
	
	public abstract List<Dealer> getAllDealers() throws CustomException;
	
	public abstract Dealer getDealerById(int dealerCode) throws CustomException;
	
	public abstract DealerAddress getDealerAddress(int dealerId) throws CustomException;
	
	/* ------------------- UPDATE ----------------   */
	public abstract Dealer updateDealer(Dealer dealer) throws CustomException;
	
	public abstract DealerAddress updateDealerAddress(DealerAddress dealerAddress) throws CustomException;
	
	/* ------------------- DELETE ----------------   */
	public abstract String deleteDealerById(int dealerCode) throws CustomException;

}
