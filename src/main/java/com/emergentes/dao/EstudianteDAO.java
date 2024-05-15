/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import java.util.List;

/**
 *
 * @author jhomara
 */
public interface EstudianteDAO {

    public void insert(Estudiante estudiante) throws Exception;

    public void update(Estudiante estudiante) throws Exception;

    public void delete(int id) throws Exception;

    public List<Estudiante> getAll() throws Exception;

    public Estudiante getById(int id) throws Exception;
}
