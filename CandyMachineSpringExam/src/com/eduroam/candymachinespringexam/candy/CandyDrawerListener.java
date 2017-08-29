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
import java.util.EventListener;

public interface CandyDrawerListener extends EventListener {
	
	void dispenseCandy(String candyName, int quantity, int balance);

}
