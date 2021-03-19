package com.exam.albo.service

interface Mapper<I, O> {
    suspend fun map(input: I): O
}