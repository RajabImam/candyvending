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

public abstract class Candy implements CandyDrawerListener {
	private EventListenerList listenerList;

	public Candy() {
		listenerList = new EventListenerList();
		setCurrentQuantity(currentQuantity);
		fireNotification(name, currentQuantity);
	}
	
	String name;
	int price;
	int currentQuantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	
	public void candyGivenOut(String name, int quantityRetrieved, int balance){
		if (name == this.name){
			updateQuantity(quantityRetrieved);
				if(currentQuantity <= 21){
					fireNotification(name, currentQuantity);
				}
		}
	}
	
	void updateQuantity(int quantityRetrieved){
		setCurrentQuantity(currentQuantity-quantityRetrieved);
	}
	
	public void addListener(CandyListener cdl){
		
		listenerList.add(CandyListener.class, cdl);
	}

	public void removeListener(CandyListener cdl){
		
		listenerList.remove(CandyListener.class, cdl);
	}

	public void fireNotification(String CandyName, int currentQuantity){
		
		CandyListener[] listeners = listenerList.getListeners(CandyListener.class);        
		for(CandyListener cdls:listeners){
			cdls.candyRunningOutOfStock(CandyName, currentQuantity);
		}
	}
	
}
