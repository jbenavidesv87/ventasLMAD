/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uanl.fcfm.lmad.papw.dao;

import edu.uanl.fcfm.lmad.papw.model.Producto;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class ProductoDAO {
    
    public static Producto getProducto(int i) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection conn = pool.getConnection();
    CallableStatement cs = null;
    ResultSet rs = null;
    try {
        cs = conn.prepareCall("{ call getProducto(?) }");
        cs.setInt(1, i);
        rs = cs.executeQuery();

        Producto p = new Producto();
        while (rs.next()) 
        {
            p.setNombre(rs.getString("nombreProducto"));
            p.setPrecio(rs.getFloat("precioProducto"));
            p.setExistencia(rs.getInt("existenciaProducto"));
            p.setDescripcionLarga(rs.getString("caracteristicas"));
            p.setImagen1(rs.getBinaryStream("imagenProducto1"));
            p.setImagen2(rs.getBinaryStream("imagenProducto2"));
            p.setImagen3(rs.getBinaryStream("imagenProducto3"));
            p.setVideo1(rs.getString("videoProducto1"));
            p.setVideo2(rs.getString("videoProducto2"));
            p.setVideo3(rs.getString("videoProducto3"));
            p.setIdSubcategoria(rs.getInt("idSubCategoria"));
            p.setIdUsuario(0);
        }
        return p;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    } finally {
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(cs);
        pool.freeConnection(conn);
    }
}
    
    public static void setProducto(Producto p)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call insertarProducto(?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, p.getNombre());
            cs.setFloat(2, p.getPrecio());
            cs.setInt(3, p.getExistencia());
            cs.setString(4, p.getDescripcionLarga());
            cs.setBinaryStream(5, p.getImagen1());
            cs.setBinaryStream(6, p.getImagen2());
            cs.setBinaryStream(7, p.getImagen3());
            cs.setString(8, p.getVideo1());
            cs.setString(9, p.getVideo2());
            cs.setString(10, p.getVideo3());
            cs.setInt(11, p.getIdUsuario());
            cs.setInt(12, p.getIdSubcategoria());
            
            rs = cs.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static void editarProducto(Producto p)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{ call editarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1, p.getIdProducto());
            cs.setString(2, p.getNombre());
            cs.setFloat(3, p.getPrecio());
            cs.setInt(4, p.getExistencia());
            cs.setString(5, p.getDescripcionLarga());
            cs.setBinaryStream(6, p.getImagen1());
            cs.setBinaryStream(7, p.getImagen2());
            cs.setBinaryStream(8, p.getImagen3());
            cs.setString(9, p.getVideo1());
            cs.setString(10, p.getVideo2());
            cs.setString(11, p.getVideo3());
            cs.setInt(12, p.getIdSubcategoria());
            cs.setBoolean(13, p.isSetImagen1());
            cs.setBoolean(14, p.isSetImagen2());
            cs.setBoolean(15, p.isSetImagen3());
            
            cs.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static List<Producto> getListaProductos (int idUsuario)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call listadoProductos(?) }");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            List<Producto> productos = new ArrayList<Producto>();
            while (rs.next()) 
            {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombreProducto"));
                p.setPrecio(rs.getFloat("precioProducto"));
                p.setExistencia(rs.getInt("existenciaProducto"));
                p.setFecha(rs.getString("date(creacionProducto)"));
                p.setComprasPendientes(rs.getInt("comprasRealizadas"));
                p.setPreguntasPendientes(rs.getInt("preguntasRealizadas"));
                
                productos.add(p);
            }
            return productos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
        
    public static void deleteProducto(int idProducto) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        
        try {
            cs = conn.prepareCall("{ call bajaProducto(?) }");
            cs.setInt(1, idProducto);
            cs.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static int insertarImagenesProductos(int idProducto, Producto p) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call insertarImagenesProducto(?,?,?,?) }");
            cs.setInt(1, idProducto);
            cs.setBinaryStream(2, p.getImagen1());
            cs.setBinaryStream(3, p.getImagen1());
            cs.setBinaryStream(4, p.getImagen1());
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
    
    public static InputStream obtenerImagenProducto(int idProducto, int imagen) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call obtenerImagenesProducto(?, ?) }");
            cs.setInt(1, idProducto);
            cs.setInt(2, imagen);
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
}
