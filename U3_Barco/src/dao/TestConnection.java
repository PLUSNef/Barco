package dao;

import java.util.List;

import model.Barco;

public class TestConnection {
	public static void main(String[] args) {
		BarcoDAOImpl barcoDAOImpl = new BarcoDAOImpl();
		barcoDAOImpl.createBarco(new Barco(6L, "ggg","ggg",10));
		
		List<Barco> barcos = barcoDAOImpl.readAllBarcos();
		for (Barco barco : barcos) {
			System.out.println(barco);
			
		}
	}
}