package com.example.solidprinciples.example.persistence

import com.example.solidprinciples.example.Shopping

interface Persistence {
    fun save(shopping: Shopping?)
}