package com.dat.repository;

import com.dat.pojo.User;
import com.dat.pojo.UserStatus;

import java.util.List;
import java.util.Map;

public interface UserRepository extends BaseRepository<User, Integer> {
    void updateStatus(Integer id, UserStatus status);
}