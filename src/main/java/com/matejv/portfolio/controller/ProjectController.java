package com.matejv.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matejv.portfolio.PortfolioServiceApplication;
import com.matejv.portfolio.entity.Project;
import com.matejv.portfolio.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

  private static final Logger logger = LoggerFactory.getLogger(PortfolioServiceApplication.class);

  @Autowired
  private ProjectService projectService;

  @PostMapping
  public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
    logger.info("Creating project: {}", project);
    Project savedProject = projectService.saveProject(project);
    return ResponseEntity.ok(savedProject);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
    Project project = projectService.findProjectById(id);
    if (project != null) {
      return ResponseEntity.ok(project);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public List<Project> getAllProjects() {
    logger.info("Fetching all projects");

    List<Project> projects = projectService.findAllProjects();

    if (projects.isEmpty()) {
      logger.info("No projects found");
    } else {
      logger.info("Found {} projects", projects);
    }

    return projects;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
    projectService.deleteProject(id);
    return ResponseEntity.noContent().build();
  }
}
