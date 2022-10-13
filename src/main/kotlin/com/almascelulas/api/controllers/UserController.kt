package com.almascelulas.api.controllers

import com.almascelulas.api.models.UserModel
import com.almascelulas.api.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository){

    @PostMapping
    fun create(@RequestBody user: UserModel): UserModel = repository.save(user)

    @GetMapping
    fun getAll(): List<UserModel> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserModel> = repository.findById(id).map {
        ResponseEntity.ok(it)
    }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: UserModel): ResponseEntity<UserModel> = repository.findById(id).map {
        val userUpdate = it.apply {
            name = user.name
            phone = user.phone
            email = user.email
        }
        ResponseEntity.ok(repository.save(userUpdate))
    }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> = repository.findById(id).map {
        repository.delete(it)
        ResponseEntity<Void>(HttpStatus.OK)
    }.orElse(ResponseEntity.notFound().build())

}