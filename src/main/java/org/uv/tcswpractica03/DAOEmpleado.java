package org.uv.tcswpractica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class DAOEmpleado implements IDAOGeneral<Empleados, Long> {
    @Override
    public boolean guardar(Empleados pojo) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean exito = false;
        
        try{
                     
            session.save(pojo);
            t.commit();
            exito = true;
        }catch(Exception e){
            if(t != null){
                t.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        
        return exito;
    }

    @Override
    public boolean eliminar(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = null;
        boolean ok = false;
        
        try{
            t = session.beginTransaction();
            Empleados e = session.get(Empleados.class, id);
            if (e != null){
                session.delete(e);
                t.commit();
                ok = true;
            }
        }catch(Exception e){
            if(t!=null){
                t.rollback();
            }
        }
        
        return ok;
    }

    @Override
    public boolean modificar(Empleados pojo, Long id) {
        Transaction t = null;
        boolean ok = false;
        Session session = HibernateUtil.getSession();
        
        try{
            t = session.beginTransaction();
            Empleados e = session.get(Empleados.class, id);
            
            if(e != null){
                e.setDireccion(pojo.getDireccion());
                e.setNombre(pojo.getNombre());
                e.setTelefono(pojo.getTelefono());
                
                t.commit();
                
                ok = true;
            }
        } catch(Exception  e){
            if (t!= null){
                t.rollback();
            }
        }finally{
            session.close();
            
        }
        
        return ok;
    }

    
    @Override
    public Empleados findByID(Long id) {
       Empleados empleado = null;
       try(Session session = HibernateUtil.getSession()){
           empleado = session.get(Empleados.class, id);
       } catch(Exception e){
           e.printStackTrace();
       }
       
       return empleado;
    }

    @Override
    public List<Empleados> findAll() {
        List<Empleados> lista = null;
        try(Session session = HibernateUtil.getSession()){
            Query<Empleados> query = session.createQuery("from Empleados", Empleados.class);
            lista = query.getResultList();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return lista;
    }

}