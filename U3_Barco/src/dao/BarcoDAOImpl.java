package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Barco;

public class BarcoDAOImpl implements BarcoDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public BarcoDAOImpl() {
		getConnetion();
	}

	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/barco", "utng", "mexico");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	@Override
	public void createBarco(Barco barco) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO barco (pais, capitan, capacidad)values (?,?,?);");
			preparedStatement.setString(1,barco.getPais());
			preparedStatement.setString(2,barco.getCapitan());
			preparedStatement.setInt(3,barco.getCapacidad());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Barco readBarco(Long id) {
		Barco barco = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM barco WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					barco = new Barco(resultSet.getLong(1), resultSet.getString(2).trim(), resultSet.getString(3).trim(),
											resultSet.getInt(4));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return barco;
	}
	@Override
	public List<Barco> readAllBarcos() {
		List<Barco> barcos = new ArrayList<Barco>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT * FROM barco");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Barco barco = new Barco(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getString(3),
									resultSet.getInt(4));
					barcos.add(barco);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return barcos;
	}
	@Override
	public void updateBarco(Barco barco) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE barco SET pais=?," + "capitan=?," + "capacidad=? WHERE id=?;");
				preparedStatement.setString(1,barco.getPais() );
				preparedStatement.setString(2,barco.getCapitan() );
				preparedStatement.setInt(3,barco.getCapacidad());
				preparedStatement.setLong(4, barco.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public void deleteBarco(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM barco WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
}
