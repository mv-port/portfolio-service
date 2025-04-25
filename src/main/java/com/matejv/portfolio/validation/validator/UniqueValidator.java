package com.matejv.portfolio.validation.validator;

import com.matejv.portfolio.validation.annotation.Unique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

  private EntityManager entityManager;

  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  private String fieldName;
  private Class<?> entityClass;

  @Override
  public void initialize(Unique constraintAnnotation) {
    this.fieldName = constraintAnnotation.fieldName();
    this.entityClass = constraintAnnotation.entityClass();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (value == null) {
      // null is valid, let @NotNull handle required fields
      return true;
    }
    try {
      String query = String.format("SELECT COUNT(e) FROM %s e WHERE e.%s = :value",
          entityClass.getSimpleName(), fieldName);

      Long count = entityManager.createQuery(query, Long.class)
          .setParameter("value", value)
          .getSingleResult();
      // If count == 0, value is unique
      return count == 0;
    } catch (Exception ex) {
      // Log error for debugging
      ex.printStackTrace();
      // Fail safe! If we cannot check uniqueness, return true (allow the insert).
      // Or, if you want to block on error, return false.
      return true;
    }
  }
}
