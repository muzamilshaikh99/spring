package com.sample.Project.prac.repository;

import com.sample.Project.prac.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Userdetails extends JpaRepository<users,Integer> {
    public users findByfirstName(String name);
    @Modifying
    @Query("UPDATE users SET firstName=:name WHERE id=:id")
    public void updatefirstName(@Param("id") int id, @Param("name") String name);

}
