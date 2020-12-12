/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import helpers.Converts;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
@Entity
@Table (name = "Contato")
public class Contato {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name = "codigo", nullable = false)
    public int codigo;
    
    @Column (name = "data", length = 10, nullable = false)
    public String data;
    
    @Column (name = "hora", length = 5, nullable = false)
    public String hora;
    
    @Column (name = "assunto",nullable = false)
    public String assunto;
   
    @Column(name = "representante_codigo")
    public int representante_codigo;
   
    public String dateBr() throws ParseException{
        return Converts.convertDateFromUsaToBr(this.data);
    }
    
}
