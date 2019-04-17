/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.business;

import com.cppcorp.entities.Register;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author grbg2
 */
public class RegisterBusiness extends Register{
    
    /** UNFINISHED
     * This will save a new register at the block
     * of that register belongs (the validation if
     * already exists a register in that block of 
     * time will be made by the JFrame)
     * @return true if the Register was save with
     *         success
     */
    public boolean setAsANewRegister(){
        return true;
    }
    /**UNFINISHED
     * This method get all registers of a Day, doesnt
     * of what area or process it is (Maybe will be 
     * useless)
     * @param day
     * @return 
     */
    public List<Register> getAllRegisterOfADay(Date day){
        List<Register> registers = new ArrayList<>();
        return registers;
    }
    /**UNFINISHED
     * This will return all registers from  a Day and Microcell
     * @param process
     * @param date
     * @param microcell
     * @return 
     */
    public List<Register> getMCFromProcess(Process process, Date date, int microcell){
        List<Register> registers = new ArrayList<>();
        return registers;
    }
    /**UNFINISHED
     * this will get all registers unfilled of the current day
     * @return 
     */
    public List<Register> getAllUnfilledRegister(){
        List<Register> registers = new ArrayList<>();
        return registers;
    }
    
    
}
