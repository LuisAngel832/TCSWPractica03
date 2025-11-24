/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tcswpractica03;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author luis
 */
public class TCSWPractica03 {

    public static void main(String[] args) {
        DAOEmpleado dao = new DAOEmpleado();
        
        Empleados e = new Empleados();
        
        e.setNombre("wikiman");
        e.setDireccion("av wikiman");
        e.setTelefono("777777");
        
        dao.guardar(e);
    }
}
