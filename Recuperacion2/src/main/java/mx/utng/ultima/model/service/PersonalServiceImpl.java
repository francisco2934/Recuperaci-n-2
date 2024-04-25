package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IPersonalDao;
import mx.utng.ultima.model.entity.Personal;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class PersonalServiceImpl implements IPersonalService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IPersonalDao personalDao;

    @Transactional(readOnly = true)
    @Override
    public List<Personal> list() {
        return personalDao.list();
    }

    @Transactional
    @Override
    public void save(Personal personal) {
        personalDao.save(personal);
    }

    @Transactional(readOnly = true)
    @Override
    public Personal getById(Long id) {
        return personalDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        personalDao.delete(id);
    }
    
}

