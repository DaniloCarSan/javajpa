/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
@Entity
@Table (name = "Telefone")
public class Telefone {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name = "codigo", nullable = false)
    public int codigo;
    
    @Column (name = "numero", length = 30, nullable = false)
    public String numero;
    
    @Column (name = "tipo", length = 1, nullable = false)
    public int tipo;
    
    @Column(name = "representante_codigo")
    public int representante_codigo;
    
    public String getTelefoneTipo(){
        switch(this.tipo)
        {
            case 0:
               return "Comercial";
            case 1:
               return "Residencial";
            default:
                return "Recados";
        }
    }

    
}
