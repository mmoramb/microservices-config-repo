package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
@NoRepositoryBean
public interface MyBaseRepository<T, ID> extends Repository<T, ID>{
	Optional<T> findById(ID id);

	<S extends T> S save(S entity);
}
