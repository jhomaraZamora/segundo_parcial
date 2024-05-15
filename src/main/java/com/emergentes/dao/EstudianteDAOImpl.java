/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhomara
 */
public class EstudianteDAOImpl extends ConexionDB implements EstudianteDAO {

    public EstudianteDAOImpl() throws ClassNotFoundException {
    }

    @Override
    public void insert(Estudiante est) throws Exception {
        String sql = "INSERT INTO estudiante(nombre, apellido, seminario, confirmado, fecha) VALUES (?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);

        ps.setString(1, est.getNombre());
        ps.setString(2, est.getApellido());
        ps.setString(3, est.getSeminario());
        ps.setString(4, est.getConfirmado());
        ps.setString(5, est.getFecha());

        ps.executeUpdate();
    }

    @Override
    public void update(Estudiante est) throws Exception {
        String sql = "UPDATE estudiante SET nombre=?, apellido= ?, seminario=?, confirmado=?, fecha=? WHERE id =?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, est.getNombre());
        ps.setString(2, est.getApellido());
        ps.setString(3, est.getSeminario());
        ps.setString(4, est.getConfirmado());
        ps.setString(5, est.getFecha());
        ps.setInt(6, est.getId());

        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM estudiante WHERE id =?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        String sql = "SELECT * FROM estudiante";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Estudiante>();

        while (rs.next()) {
            Estudiante e = new Estudiante();

            e.setId(rs.getInt("id"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
            e.setSeminario(rs.getString("seminario"));
            e.setConfirmado(rs.getString("confirmado"));
            e.setFecha(rs.getString("fecha"));

            lista.add(e);
        }
        // this.desconectar();
        return lista;
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        String sql = "SELECT * FROM estudiante WHERE id=?";
        Estudiante e = new Estudiante();

        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setSeminario(rs.getString("seminario"));
                e.setConfirmado(rs.getString("confirmado"));
                e.setFecha(rs.getString("fecha"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al encontrar el registro " + ex.getMessage());
        } finally {
            this.desconectar();
        }
        return e;
    }

}
