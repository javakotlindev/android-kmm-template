package com.ecosystem.monoraise

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform