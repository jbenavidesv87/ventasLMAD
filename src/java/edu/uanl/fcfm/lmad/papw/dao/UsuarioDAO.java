/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uanl.fcfm.lmad.papw.dao;

import edu.uanl.fcfm.lmad.papw.model.Usuario;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alberto
 */
public class UsuarioDAO {
    
    public static boolean setUsuario(Usuario u) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs;
        
        try {
            cs = conn.prepareCall("{ call insertarUsuario(?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, u.getNickname());
            cs.setString(2, u.getContrasenia());
            cs.setString(3, u.getCorreoElectronico());
            cs.setString(4, u.getNombre());
            cs.setString(5, u.getApellidoPaterno());
            cs.setString(6, u.getApellidoMaterno());
            cs.setString(7, u.getFechaNacimiento());
            cs.setString(8, u.getSexo());
            cs.setString(9, u.getTelefono());
            rs = cs.executeQuery();
            
            rs.first();
            return rs.getString(1).equals("1");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        return false;
    }
    
    public static Usuario getUsuario(int idUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs;
        
        try {
            Usuario u = new Usuario();
            cs = conn.prepareCall("{ call getUsuario(?) }");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            
            while(rs.next())
            {
            
            u.setNickname(rs.getString("nickUsuario"));
            u.setContrasenia(rs.getString("contraseniaUsuario"));
            u.setCorreoElectronico(rs.getString("correoUsuario"));
            u.setNombre(rs.getString("nombreUsuario"));
            u.setApellidoPaterno(rs.getString("apellidoPaternoUsuario"));
            u.setApellidoMaterno(rs.getString("apellidoMaternoUsuario"));
            u.setFechaNacimiento(rs.getString("fechaNacimientoUsuario"));
            u.setSexo(rs.getString("sexoUsuario"));
            u.setTelefono(rs.getString("telefonoUsuario")); 
            }
            
            return u;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        return null;
    }
    
    public static void updateUsuario(Usuario u) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        
        try {
            cs = conn.prepareCall("{ call editarUsuario(?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1, u.getIdUsuario());
            cs.setString(2, u.getContrasenia());
            cs.setString(3, u.getCorreoElectronico());
            cs.setString(4, u.getNombre());
            cs.setString(5, u.getApellidoPaterno());
            cs.setString(6, u.getApellidoMaterno());
            cs.setString(7, u.getFechaNacimiento());
            cs.setString(8, u.getSexo());
            cs.setString(9, u.getTelefono());
            cs.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static int insertarImagen(Usuario u) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call insertarImagen(?,?,?) }");
            cs.setString(1, u.getNickname());
            cs.setString(2, u.getTipo());
            cs.setBlob(3, u.getStream());
            rs = cs.executeQuery();
           
            if (rs.next()){
                 int id = rs.getInt("idUsuario");
                 return id;  
            }            
            else 
                return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
     
    public static InputStream obtenerImagen(int idUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call obtenerImagen(?) }");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getBinaryStream(1);
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    } 
    
    public static void deleteUsuario(int idUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        
        try {
            cs = conn.prepareCall("{ call bajaUsuario(?) }");
            cs.setInt(1, idUsuario);
            cs.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
