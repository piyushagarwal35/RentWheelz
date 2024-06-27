package com.app.copilot.RentWheelz.repository;

import com.app.copilot.RentWheelz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
