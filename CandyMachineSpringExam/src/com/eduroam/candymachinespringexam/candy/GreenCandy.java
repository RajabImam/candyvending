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
public class GreenCandy extends Candy implements CandyDrawerListener  {

	public GreenCandy() {
		super();
		name = "Green";
		price = 25;
		currentQuantity = 17;
	}

    @Override
    public void dispenseCandy(String candyName, int quantity, int balance) {

    }

   

}
