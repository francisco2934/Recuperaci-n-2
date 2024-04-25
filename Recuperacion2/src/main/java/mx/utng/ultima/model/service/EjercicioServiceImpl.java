package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.ultima.model.dao.IEjercicioDao;
import mx.utng.ultima.model.entity.Ejercicio;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class EjercicioServiceImpl implements IEjercicioService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IEjercicioDao ejercicioDao;

    @Transactional(readOnly = true)
    @Override
    public List<Ejercicio> list() {
        return ejercicioDao.list();
    }

    @Transactional
    @Override
    public void save(Ejercicio ejercicio) {
        ejercicioDao.save(ejercicio);
    }

    @Transactional(readOnly = true)
    @Override
    public Ejercicio getById(Long id) {
        return ejercicioDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        ejercicioDao.delete(id);
    }
    
}

