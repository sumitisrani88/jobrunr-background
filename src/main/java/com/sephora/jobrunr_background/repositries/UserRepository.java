package com.sephora.jobrunr_background.repositries;

import com.sephora.jobrunr_background.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  public User findById(int id);
}
