package com.almascelulas.api.repository

import com.almascelulas.api.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserModel, Long>