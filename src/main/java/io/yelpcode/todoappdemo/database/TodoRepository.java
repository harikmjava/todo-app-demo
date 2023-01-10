package io.yelpcode.todoappdemo.database;

import io.yelpcode.todoappdemo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TodoRepository extends JpaRepository<Todo, BigInteger> {
}
