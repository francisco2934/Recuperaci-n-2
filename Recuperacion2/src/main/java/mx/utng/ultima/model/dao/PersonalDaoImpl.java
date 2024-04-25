package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Personal;

@Repository
public class PersonalDaoImpl implements IPersonalDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Personal> list() {
        return em.createQuery("from Personal").getResultList();
    }

    @Override
    public void save(Personal personal) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(personal.getId() != null && personal.getId()>0){
            em.merge(personal);
        }else{
            //Registro nuevo al usar persist
            em.persist(personal);
        }
    }

    @Override
    public Personal getById(Long id) {
        return em.find(Personal.class, id);
    }

    @Override
    public void delete(Long id) {
      Personal personal = getById(id);
      em.remove(personal);
    }
    

}
