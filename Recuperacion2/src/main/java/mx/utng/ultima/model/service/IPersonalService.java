package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Personal;



public interface IPersonalService {
    List<Personal> list();
    void save(Personal personal);
    Personal getById(Long id);
    void delete(Long id);
}

