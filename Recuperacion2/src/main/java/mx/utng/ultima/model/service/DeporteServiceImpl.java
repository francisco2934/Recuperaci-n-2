package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IDeporteDao;
import mx.utng.ultima.model.entity.Deporte;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class DeporteServiceImpl implements IDeporteService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IDeporteDao deporteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Deporte> list() {
        return deporteDao.list();
    }

    @Transactional
    @Override
    public void save(Deporte deporte) {
        deporteDao.save(deporte);
    }

    @Transactional(readOnly = true)
    @Override
    public Deporte getById(Long id) {
        return deporteDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        deporteDao.delete(id);
    }
    
}

