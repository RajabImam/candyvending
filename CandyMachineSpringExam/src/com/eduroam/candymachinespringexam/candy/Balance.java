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
public class Balance implements CandyDrawerListener {

	public Balance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispenseCandy(String candyName, int quantity, int balance) {
		
		print(" Balance : " + " " + balance + " XAF");
	}
		void print(String message){
		System.out.println(message);
	}
    
}
