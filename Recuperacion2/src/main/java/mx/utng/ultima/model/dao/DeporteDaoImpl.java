package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Deporte;

@Repository
public class DeporteDaoImpl implements IDeporteDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Deporte> list() {
        return em.createQuery("from Deporte").getResultList();
    }

    @Override
    public void save(Deporte deporte) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(deporte.getId() != null && deporte.getId()>0){
            em.merge(deporte);
        }else{
            //Registro nuevo al usar persist
            em.persist(deporte);
        }
    }

    @Override
    public Deporte getById(Long id) {
        return em.find(Deporte.class, id);
    }

    @Override
    public void delete(Long id) {
      Deporte deporte = getById(id);
      em.remove(deporte);
    }
    

}
