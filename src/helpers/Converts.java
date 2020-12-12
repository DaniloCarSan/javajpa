/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
public class Converts {
    
    public static String convertDateFromBrToUsa(String data) throws ParseException{
        Date formatoBr = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        SimpleDateFormat formatoUs = new SimpleDateFormat("yyyy-MM-dd");
        return formatoUs.format(formatoBr);
    }
    
    public static String convertDateFromUsaToBr(String data) throws ParseException{
        Date formatoUsa = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
        return formatoBr.format(formatoUsa);
    }
}
