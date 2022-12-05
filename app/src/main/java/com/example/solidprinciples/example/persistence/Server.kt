package com.example.solidprinciples.example.persistence

import com.example.solidprinciples.example.Shopping

class Server: Persistence {
    override fun save(shopping: Shopping?) {
        // save the data on the server
    }
}