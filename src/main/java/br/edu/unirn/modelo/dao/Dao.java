package br.edu.unirn.modelo.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Serializable> {

	T salvar(T entidade);
	
	T buscar(Long id);
	
	List<T> listarTodos();
	
	void deletar(T entidade);
	
	void deletar(Long id);

	
}
