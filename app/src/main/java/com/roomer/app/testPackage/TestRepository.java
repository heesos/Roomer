package com.roomer.app.testPackage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestPOJO, Integer> {
}
