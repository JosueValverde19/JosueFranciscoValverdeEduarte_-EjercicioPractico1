
package com.EjercicioPractico1.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="estudiantes")
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String nombre;
    private String identificacion;
    private String nivelCursando;
    private int edad;
    private double altura;
    private double peso;
    private String genero;
    public Estudiantes() {
    }
    public Estudiantes(String nombre, String identificacion, String nivelCursando, int edad, double altura, double peso,String genero) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.nivelCursando = nivelCursando;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
    }
} 