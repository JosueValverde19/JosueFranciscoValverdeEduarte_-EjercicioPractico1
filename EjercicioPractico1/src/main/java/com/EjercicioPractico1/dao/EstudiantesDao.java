
package com.EjercicioPractico1.dao;

import com.EjercicioPractico1.domain.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesDao extends JpaRepository<Estudiantes, Integer> {

}
