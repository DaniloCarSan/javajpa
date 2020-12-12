/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.InputMismatchException;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
public class Validators {
    
    public static DocumentListener getDocumentListener(Runnable call){
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               validate(); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               validate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
            public void validate() {
                new Thread(call).start();
            }
        };
    }
    
    public static String validateTextRequired(String text){
        
        if(text.isEmpty())
        {
            return "Campo obrigatório !";
        }
        else if( ! text.matches("[a-z0-9A-Z ]{1,}"))
        {
            return "Campo deve conter apenas letras e numeros !";
        }
        
       return null;
    }
    
    public static String validateDateRequired(String date){
    
       if(date.isEmpty())
        {
            return "Campo obrigatório !";
        }
        
       if(! date.matches("(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}"))
       {
           return "Campo inválido !";
           
       }
    
       return null; 
    }
    
    public static String validateHoraRequired(String date){
    
       if(date.isEmpty())
        {
            return "Campo obrigatório !";
        }
        
       if(! date.matches("[0-2][0-3]:[0-5][0-9]"))
       {
           return "Campo inválido !";
           
       }
    
       return null; 
    }
    
    public static String validateCPFRequired(String cpf){
        
        if(cpf.isEmpty())
        {
            return "Campo obrigatório !";
        }
        
        if(! isCPF(cpf))
        {
            return "CPF invalido ! ";
        }
        
        return null;
    }
    
    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        CPF = CPF.replace(".", "").replace("-", "");
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
    }   
    
    public static String validateTelefoneRequired(String text){
        
        if(text.isEmpty())
        {
            return "Campo obrigatório !";
        }
        
        if( ! text.matches("\\([0-9]{2}\\) [0-9]{4}-[0-9]{4}"))
        {
            return "ex:(##) ####-####";
        }
        
       return null;
    }
    
    public static String validateCelularRequired(String text){
        
        if(text.isEmpty())
        {
            return "Campo obrigatório !";
        }
        
        if( ! text.matches("\\([0-9]{2}\\) [0-9]{5}-[0-9]{4}"))
        {
            return "ex: (##) #####-####";
        }
        
       return null;
    }
    
    public static String validateNumberRequired(String text){
        
        if(text.isEmpty())
        {
            return "Campo obrigatório !";
        }
        
        if( ! text.matches("[0-9]{1,}"))
        {
            return "Campo invalido";
        }
        
       return null;
    }
    
  
}
