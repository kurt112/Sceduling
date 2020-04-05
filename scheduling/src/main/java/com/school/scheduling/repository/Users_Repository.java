package com.school.scheduling.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Users;

public interface Users_Repository extends JpaRepository<Users, String> {



}
