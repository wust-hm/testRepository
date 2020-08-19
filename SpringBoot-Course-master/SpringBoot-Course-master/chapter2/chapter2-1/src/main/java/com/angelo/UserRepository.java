package com.angelo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * @description: 扩展，通过名字查询
     * @param name: 名字
     * @return: java.util.List<com.angelo.User>
     * @date: 2020/8/19 8:12
     */
    public List<User> findByName(String name);
}
