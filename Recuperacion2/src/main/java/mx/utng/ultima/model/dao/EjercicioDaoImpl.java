package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Ejercicio;

@Repository
public class EjercicioDaoImpl implements IEjercicioDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Ejercicio> list() {
        return em.createQuery("from Ejercicio").getResultList();
    }

    @Override
    public void save(Ejercicio ejercicio) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(ejercicio.getId() != null && ejercicio.getId()>0){
            em.merge(ejercicio);
        }else{
            //Registro nuevo al usar persist
            em.persist(ejercicio);
        }
    }

    @Override
    public Ejercicio getById(Long id) {
        return em.find(Ejercicio.class, id);
    }

    @Override
    public void delete(Long id) {
      Ejercicio ejercicio = getById(id);
      em.remove(ejercicio);
    }
    

}
