
package com.EjercicioPractico1.controller;

import com.EjercicioPractico1.domain.Estudiantes;
import com.EjercicioPractico1.service.EstudiantesService;
import com.EjercicioPractico1.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class EstudiantesController {
    @Controller
@Slf4j
@RequestMapping("/estudiantes")
public class EstudiantesController {
    
    @Autowired
    private EstudiantesService categoriaService;
    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getEstudiantes(false);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("totalestudiantes", estudiantes.size());
        return "/estudiantes/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Estudiantes categoria) {
        return "/estudiantes/modifica";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String estudiantesGuardar(Estudiantes estudiantes,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriaService.save(estudiantes);
            estudiantes.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "estudiantes", 
                            estudiantes.getId()));
        }
        categoriaService.save(estudiantes);
        return "redirect:/estudiantes/listado";
    }
    @GetMapping("/eliminar/{idEstudiantes}")
    public String categoriaEliminar(Estudiantes estudiantes) {
        categoriaService.delete(estudiantes);
        return "redirect:/estudiantes/listado";
    }
    @GetMapping("/modificar/{idEstudiantes}")
    public String categoriaModificar(Estudiantes estudiantes, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
    
}
