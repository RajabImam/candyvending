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
import java.util.Scanner;

import javax.swing.event.EventListenerList;

public class CustomerInputManager {
	private EventListenerList listenerList;
	
	int coinsReceived;
	int choiceReceived;

	public CustomerInputManager() {
		super();
		listenerList = new EventListenerList();	
		
	}
	
	
	void newCommand (){
		int quantity = 0;
		int balance = 0;
		String candyName = "";
		print(" Hi, *********** Welcome To RajTech Candy Vending Machine ************ \n"
				+ "We are ready to serve you ........"
				+ "		Please Enter your Coins and Choose your Candy \n");
		getCoins();
		getChoice();
		
		switch(choiceReceived){		
			case 1: {
				candyName = "Blue";
				quantity = coinsReceived/75;
				balance = coinsReceived - (quantity*75);
					if (quantity < 1){
						print(" Sorry! Insufficient coins for this candy.");
						balance = coinsReceived;
						break;
					}
			}
			break;
			
			case 2: {
				candyName = "Green";
				quantity = coinsReceived/25;
				balance = coinsReceived - (quantity*25);
					if (quantity < 1){
						print(" Sorry! Insufficient coins for this candy.");
						balance = coinsReceived;
						break;
					}
			}
			break;
			
			case 3: {
				candyName = "Red";
				quantity = coinsReceived/125;
				balance = coinsReceived - (quantity*125);
					if (quantity < 1){
						print(" Sorry! Insufficient coins for this candy.");
						balance = coinsReceived;
						break;
					}
			}
			break;
		}
		
		fireNotification(candyName,quantity, balance, coinsReceived);
		
		ending();
		
	}
	
	void ending(){
		print("				Enter 0 to return to Menu or any key to End");
		String restart = reply.next();
		switch (restart) {
		case "0" : newCommand();	
		break;
		default: System.out.print("	!!!	End.. Thank you!!!	");
		}
	}
	
	
	static Scanner reply = new Scanner(System.in);	
	 static String userInput = "";
	
	 private void getCoins(){
			userInput= reply.next();
			while (isInteger(userInput) == false){
			print("Please Enter a valid amount (in figures):  ");
			userInput = reply.next();
			}		
			if (Integer.parseInt(userInput) != 100 && Integer.parseInt(userInput) != 500 ){ 
				print("[we accept just coins of 100 XAF and 500 XAF]	Please Enter a valid amount (in figures): ");
				getCoins();
			}
			
			coinsReceived = Integer.valueOf(userInput);
			
		}
	
	 private void getChoice(){
			
			print("		Please a choice for your candy: \n"
					+ "					1 = Blue (75 XAF) \n"
					+ "					2 = Green (25 XAF) \n"
					+ "					3 = Red (125 XAF) \n");
			
			userInput= reply.next();
			while (isInteger(userInput) == false){
			print("Please Enter a valid choice (in figures):  ");
			userInput = reply.next();
			}		
			if (Integer.parseInt(userInput) != 1 && Integer.parseInt(userInput) != 2 && Integer.parseInt(userInput) != 3 ){ 
				print("[Your choice must be between 1, 2 and 3]	Please Enter a valid choice (in figures): ");
				getChoice();
			}
			
			choiceReceived = Integer.valueOf(userInput);
		}
	 
	
	public boolean isInteger(String input) {
		
		  try {
		    Integer.parseInt( input );
		    return true;
		   }
		    catch( Exception e ) {
		    return false;
		   }
	}
	
	void print(String message){
		System.out.println(message);
	}
	
	public void addListener(CustomerInputManagerListener il){
		
		listenerList.add(CustomerInputManagerListener.class, il);
	}

	public void removeListener(CustomerInputManagerListener iml){
		
		listenerList.remove(CustomerInputManagerListener.class, iml);
	}

	void fireNotification(String candyName, int quantity, int balance, int coinsReceived){
		
		CustomerInputManagerListener[] listeners = listenerList.getListeners(CustomerInputManagerListener.class);        
		for(CustomerInputManagerListener imls:listeners){
			imls.giveCandyOut(candyName,quantity, balance, coinsReceived);
		}
	}

   



	
}

