package com.qa.repo;


import com.qa.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sectRepository extends JpaRepository<Sector,Long> {

}
