
package com.EjercicioPractico1.service;

import com.EjercicioPractico1.domain.Estudiantes;
import java.util.List;

public interface EstudiantesService {
    
    public List <Estudiantes> getEstudiantes();
    
    public Estudiantes getEstudiantes(Estudiantes estudiantes);
    
    public void save(Estudiantes estudiantes);
    
        public void delete(Estudiantes estudiantes);
    
}
