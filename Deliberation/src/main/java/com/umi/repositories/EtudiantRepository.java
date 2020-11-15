package com.umi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.umi.models.Etudiant;
import com.umi.models.InscriptionEnLigne;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	
	@Query("select s from Etudiant s")
	List<Etudiant> getAllStudents();
	
	@Query("select s from Etudiant s where s.nationality = :nationality")
	List<Etudiant> getStudentByNationality(@Param("nationality") String nationality);
	
	@Query("select id from Etudiant s where first_name_fr = :a and last_name_fr = :b")
	int getIdEtudiantByName(@Param("a")String first_name_fr,@Param("b")String last_name_fr);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO Etudiant SELECT * FROM InscriptionEnligne WHERE id=x" , nativeQuery=true)
    void copyIeEtudiant(@Param("x")int id);

}
