package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Deporte;

public interface IDeporteService {
    List<Deporte> list();
    void save(Deporte deporte);
    Deporte getById(Long id);
    void delete(Long id);
}

