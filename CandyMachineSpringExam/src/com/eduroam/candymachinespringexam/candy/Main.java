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
public class Main {

	public static void main(String[] args) {
		
		CustomerInputManager cim = new CustomerInputManager();
		CandyDrawer cDrawer = new CandyDrawer();
		
		BlueCandy blueCandy = new BlueCandy();
		GreenCandy greenCandy = new GreenCandy();
		RedCandy redCandy = new RedCandy();
		
		cim.addListener(cDrawer);		
		cDrawer.addListener(blueCandy);
		cDrawer.addListener(greenCandy);
		cDrawer.addListener(redCandy);
		
		blueCandy.addListener(cDrawer);
		greenCandy.addListener(cDrawer);
		redCandy.addListener(cDrawer);
		
		Balance myBD = new Balance();
		cDrawer.addListener(myBD);
		
		cim.newCommand();
	}

}
