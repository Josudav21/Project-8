package com.example.project8.utils

sealed class Resource<T>(val data: T? = null, val msg: String) {
    class OK <T>(data: T, message: String): Resource<T>(data = data, msg = message)
    class Failed<T>(message: String): Resource<T>(msg = message)
}
