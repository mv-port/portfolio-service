package com.matejv.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matejv.portfolio.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

  List<Project> findByName(String name);

  List<Project> findByNameIgnoreCase(String name);

}
