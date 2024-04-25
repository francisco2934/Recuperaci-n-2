package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Ejercicio;



public interface IEjercicioService {
    List<Ejercicio> list();
    void save(Ejercicio ejercicio);
    Ejercicio getById(Long id);
    void delete(Long id);
}

