package com.umi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.umi.models.InscriptionPedagogique;
import com.umi.models.Semestre;
import com.umi.models.Module;

public interface InscriptionPedagogiqueRepository extends JpaRepository<InscriptionPedagogique, Integer>{

	@Query("select s from InscriptionPedagogique s")
	List<InscriptionPedagogique> getAllInscriptionsPedagogique();
	
	@Query("select s from InscriptionPedagogique s where semestre=:x")
	List<InscriptionPedagogique> getInscriptionsPedagogiqueBySemestre(@Param("x")Semestre semestre);
	
	@Transactional
	@Modifying
	@Query("update InscriptionPedagogique s set s.module=:x where s.id_ip=:y")
	void updateInscriptionPedagogique(@Param("y")int id,@Param("x")List<Module> listModules);
}
