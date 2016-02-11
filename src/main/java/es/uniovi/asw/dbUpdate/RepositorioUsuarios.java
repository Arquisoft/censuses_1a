package es.uniovi.asw.dbUpdate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.logica.User;

public interface RepositorioUsuarios extends CrudRepository<User, Long>{
	
	List<User> buscarPorNombre(String nombre);

}
