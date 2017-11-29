package dao;

import java.util.List;

import model.Barco;

public interface BarcoDAO {
	void createBarco(Barco barco);
	Barco readBarco(Long id);
	List<Barco>readAllBarcos();
	void updateBarco(Barco barco);
	void deleteBarco(Long id);

}
