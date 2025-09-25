package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Entites.Emplooye;

@Repository
public interface EmplooyeRepository extends JpaRepository<Emplooye, Long>{

}
