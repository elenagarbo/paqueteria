package com.ecodeup.articulos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecodeup.articulos.model.Articulo;
import com.ecodeup.articulos.model.Conexion;

/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */

public class ArticuloDAO {
	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Articulo articulo) throws SQLException {
		String sql = "INSERT INTO articulos (id, origen, destino, paquete, fechallegada, remitente, transportista, precio) VALUES (?, ?, ?,?,?,?,?,?)";
//		System.out.println(articulo.getDescripcion());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		statement.setString(1, null);
		statement.setString(2, articulo.getOrigen());
		statement.setString(3, articulo.getDestino());
		statement.setString(4, articulo.getPaquete());
		statement.setDate(5, articulo.getFechallegada());
		statement.setString(6, articulo.getRemitente());
		statement.setString(7, articulo.getTransportista());
		statement.setDouble(6, articulo.getPrecio());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Articulo> listarArticulos() throws SQLException, ParseException {

		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String origen = resulSet.getString("origen");
			String destino = resulSet.getString("destino");
			String paquete = resulSet.getString("paquete");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date fechallegada = formatter.parse(resulSet.getString("fechallegada"));
			String remitente = resulSet.getString("existencia");
			String transportista = resulSet.getString("existencia");
			Double precio = resulSet.getDouble("precio");
			
			
			Articulo articulo = new Articulo(id, origen, destino, paquete, fechallegada, remitente, transportista, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}

	// obtener por id
	public Articulo obtenerPorId(int id) throws SQLException, ParseException {
		Articulo articulo = null;

		String sql = "SELECT * FROM articulos WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			articulo = new Articulo(res.getInt("id"), res.getString("origen"), res.getString("destino"), res.getString("paquete"), formatter.parse("fechallegada"),
					res.getString("remitente"),res.getString("transportista"), res.getDouble("precio"));
		}
		res.close();
		con.desconectar();

		return articulo;
	}

	// actualizar
//	public boolean actualizar(Articulo articulo) throws SQLException {
//		boolean rowActualizar = false;
//		String sql = "UPDATE articulos SET codigo=?,nombre=?,descripcion=?,existencia=?, precio=? WHERE id=?";
//		con.conectar();
//		connection = con.getJdbcConnection();
//		PreparedStatement statement = connection.prepareStatement(sql);
//		statement.setString(1, articulo.getOrigen());
//		statement.setString(2, articulo.getDestino());
//		statement.setString(3, articulo.getDescripcion());
//		statement.setDouble(4, articulo.getExistencia());
//		System.out.println(articulo.getPrecio());
//		statement.setDouble(5, articulo.getPrecio());
//		statement.setInt(6, articulo.getId());
//
//		rowActualizar = statement.executeUpdate() > 0;
//		statement.close();
//		con.desconectar();
//		return rowActualizar;
//	}
	
	//eliminar
//	public boolean eliminar(Articulo articulo) throws SQLException {
//		boolean rowEliminar = false;
//		String sql = "DELETE FROM articulos WHERE ID=?";
//		con.conectar();
//		connection = con.getJdbcConnection();
//		PreparedStatement statement = connection.prepareStatement(sql);
//		statement.setInt(1, articulo.getId());
//
//		rowEliminar = statement.executeUpdate() > 0;
//		statement.close();
//		con.desconectar();
//
//		return rowEliminar;
//	}
}