/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eduroam.candymachinespringexam.candy;

/**
 *
 * @author Al-Imam Rajab ICTU1040490 OOAD EXAM 06/07/17
 */
import javax.swing.event.EventListenerList;

public class CandyDrawer implements CustomerInputManagerListener, CandyListener{
	private EventListenerList listenerList;
	boolean isOutOfStock = false;
	
	int blueQty =5;
	int greenQty;
	int redQty;

	
	public CandyDrawer() {
		super();
		listenerList = new EventListenerList();	
		
	}
	
	public void candyRunningOutOfStock(String candyName, int currentQuantity) {
		switch (candyName){
		case "Blue" :{
			blueQty = currentQuantity;
		}break;
		
		case "Green" :{
			greenQty = currentQuantity;
		}break;
		
		case "Red" :{
			redQty = currentQuantity;
		}break;		
	}
		
	}
	
	@Override
	public void giveCandyOut(String candyName, int quantity, int balance, int coinsReceived){
		
		switch (candyName){
			case "Blue" :{
				if (blueQty < quantity){
					isOutOfStock = true;
				}
			}break;
			
			case "Green" :{
				if (greenQty < quantity){
					isOutOfStock = true;
				}
			}break;
			
			case "Red" :{
				if (redQty < quantity){
					isOutOfStock = true;
				}
			}break;		
		}
		
		if (isOutOfStock == false){
			print(" " + quantity + " " + candyName + " Candy given out. Thank You for Patronage\n");
			fireNotification(candyName,quantity, balance);
		} else {
			print(" Sorry ! Insufficient " + candyName + " Candy to Satisfy your demand. Thank You ! \n"); 
			fireNotification("",0, coinsReceived);
		}
	}
	
	void print(String message){
		System.out.println(message);
	}
	
	public void addListener(CandyDrawerListener cdl){
		
		listenerList.add(CandyDrawerListener.class, cdl);
	}

	public void removeListener(CandyDrawerListener cdl){
		
		listenerList.remove(CandyDrawerListener.class, cdl);
	}

	public void fireNotification(String candyName, int quantity, int balance){
		
		CandyDrawerListener[] listeners = listenerList.getListeners(CandyDrawerListener.class);        
		for(CandyDrawerListener cdls:listeners){
			cdls.dispenseCandy(candyName, quantity, balance);
		}
	}



	



	

}

