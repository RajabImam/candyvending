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
public class RedCandy extends Candy implements CandyDrawerListener  {

	public RedCandy() {
		super();
		name = "Red";
		price = 125;
		currentQuantity = 40;
	}

    @Override
    public void dispenseCandy(String candyName, int quantity, int balance) {

    }

}
