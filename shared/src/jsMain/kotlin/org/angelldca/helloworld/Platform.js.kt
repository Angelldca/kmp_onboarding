package org.angelldca.helloworld

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
    override val isWeb: Boolean = true
}

actual fun getPlatform(): Platform = JsPlatform()