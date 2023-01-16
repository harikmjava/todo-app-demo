package io.yelpcode.todoappdemo.database;

import io.yelpcode.todoappdemo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TodoRepository extends JpaRepository<Todo, BigInteger> {
}
