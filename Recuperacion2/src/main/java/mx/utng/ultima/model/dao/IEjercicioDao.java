package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Ejercicio;



public interface IEjercicioDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Ejercicio> list();

    //Guardar un estudiante
    void save(Ejercicio ejercicio);

    //Obterner un estudiante en especifico a partir del id
    Ejercicio getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


