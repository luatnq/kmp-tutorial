interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun platformName(): String