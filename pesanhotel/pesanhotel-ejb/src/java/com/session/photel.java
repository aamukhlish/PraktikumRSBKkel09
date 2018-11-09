/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;


import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Portege R30
 */
@Stateless
@LocalBean
public class photel {
    
    DecimalFormat a = new DecimalFormat("0.0");
    String hasil;
    
    public String standard(double param) {
        return hasil= a.format(param*200000);
    }
    public String deluxe(double param) {
        return hasil= a.format(param*500000);
    }
    public String suite(double param) {
        return hasil= a.format(param*900000);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
