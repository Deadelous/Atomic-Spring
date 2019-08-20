package com.atomic.repositories;

import com.atomic.models.Atomic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtomicRepository extends JpaRepository<Atomic, Integer> {
}
