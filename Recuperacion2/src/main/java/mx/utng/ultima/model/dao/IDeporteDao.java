package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Deporte;


public interface IDeporteDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Deporte> list();

    //Guardar un estudiante
    void save(Deporte deporte);

    //Obterner un estudiante en especifico a partir del id
    Deporte getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


