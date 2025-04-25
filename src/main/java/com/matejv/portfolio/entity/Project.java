package com.matejv.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import com.matejv.portfolio.validation.constraints.Unique;

@Entity
@Table(name = "projects")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Unique(fieldName = "name", entityClass = Project.class)
  @NotNull(message = "Project name cannot be null")
  @Size(min = 2, max = 120, message = "Project name must be between 2 and 120 characters")
  private String name;

  @NotNull(message = "Project description cannot be null")
  @Size(min = 3, max = 255, message = "Project description must be between 3 and 255 characters")
  private String description;

  @Pattern(regexp = "http(s)?://.*", message = "Project project url must start with http:// or https://")
  private String projectUrl;

  @Pattern(regexp = "http(s)?://.*", message = "Project code base (github) url must start with http:// or https://")
  private String codeBaseUrl;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  // Getters and Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProjectUrl() {
    return projectUrl;
  }

  public void setProjectUrl(String projectUrl) {
    this.projectUrl = projectUrl;
  }

  public String getCodeBaseUrl() {
    return codeBaseUrl;
  }

  public void setCodeBaseUrl(String codeBaseUrl) {
    this.codeBaseUrl = codeBaseUrl;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
