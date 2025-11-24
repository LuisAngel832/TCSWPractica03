package org.uv.tcswpractica03;

import java.util.List;

public interface IDAOGeneral <T,I>{
    public boolean guardar(T pojo);
    public boolean eliminar(I id);
    public boolean modificar(T pojo, I id);
    public T findByID(I id);
    public List<T> findAll();
    
}
