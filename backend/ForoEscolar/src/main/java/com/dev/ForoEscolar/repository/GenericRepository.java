package com.dev.ForoEscolar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T,ID> extends JpaRepository<T,ID> {

}
