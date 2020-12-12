/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
@Entity
@Table (name = "Representante")
public class Representante {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name = "codigo", nullable = false)
    public int codigo;
    
    @Column (name = "nome", length = 100, nullable = false)
    public String nome;
    
    @Column (name = "cpf", length = 14, nullable = false , unique = true)
    public String cpf;
    
    @Column (name = "empresa", length = 100, nullable = false)
    public String empresa;
    
}

