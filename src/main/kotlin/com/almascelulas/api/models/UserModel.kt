package com.almascelulas.api.models

import javax.persistence.*

@Entity
@Table(name = "user")
class UserModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var name: String,
    var phone: String,
    var email: String
)