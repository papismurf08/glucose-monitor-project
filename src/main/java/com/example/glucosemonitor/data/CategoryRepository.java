package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
