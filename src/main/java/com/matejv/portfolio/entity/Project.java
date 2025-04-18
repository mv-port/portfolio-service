package com.matejv.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Project description cannot be null")
  @Size(min= 3, max = 255, message = "Project description must be between 3 and 255 characters")
  private String description;

  @NotNull(message = "Project name cannot be null")
  @Size(min = 2, max = 120, message = "Project name must be between 2 and 120 characters")
  private String name;

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

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
