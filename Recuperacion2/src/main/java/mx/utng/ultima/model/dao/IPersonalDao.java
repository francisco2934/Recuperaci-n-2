package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Personal;



public interface IPersonalDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Personal> list();

    //Guardar un estudiante
    void save(Personal personal);

    //Obterner un estudiante en especifico a partir del id
    Personal getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


