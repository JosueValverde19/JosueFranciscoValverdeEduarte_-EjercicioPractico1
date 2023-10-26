package com.EjercicioPractico1.service.impl;

import com.EjercicioPractico1.dao.EstudiantesDao;
import com.EjercicioPractico1.domain.Estudiantes;
import com.EjercicioPractico1.service.EstudiantesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudiantesServiceImpl implements EstudiantesService{
    
    @Autowired
    private EstudiantesDao estudiantesDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Estudiantes> getEstudiantes() {
        var lista=estudiantesDao.findAll();
        return lista;
    }
    @Override
    @Transactional(readOnly = true)
    public Estudiantes getEstudiantes(Estudiantes estudiantes) {
        return estudiantesDao.findById(estudiantes.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Estudiantes estudiantes) {
        estudiantesDao.save(estudiantes);
    }

    @Override
    @Transactional
    public void delete(Estudiantes estudiantes) {
        estudiantesDao.delete(estudiantes);
    }
    
}
