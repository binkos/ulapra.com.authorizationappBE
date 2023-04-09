package ulapra.com

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import ulapra.com.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
