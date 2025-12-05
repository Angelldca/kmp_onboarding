package org.angelldca.helloworld

interface Platform {
    val name: String
    val isWeb: Boolean
}

expect fun getPlatform(): Platform