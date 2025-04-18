package com.matejv.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matejv.portfolio.entity.Project;
import com.matejv.portfolio.repository.ProjectRepository;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  // Create or update a project
  public Project saveProject(Project project) {
    return projectRepository.save(project);
  }

  // Find a project by ID
  public Project findProjectById(Long id) {
    return projectRepository.findById(id).orElse(null);
  }

  // Find projects by name
  public List<Project> findProjectsByName(String name) {
    return projectRepository.findByName(name);
  }

  // Find all projects
  public List<Project> findAllProjects() {
    return projectRepository.findAll();
  }

  // Delete a project
  public void deleteProject(Long id) {
    projectRepository.deleteById(id);
  }

}
