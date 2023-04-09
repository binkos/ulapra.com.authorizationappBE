package ulapra.com

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import ulapra.com.feature.signIn.configureSignInRouting
import ulapra.com.feature.signUp.configureSignUpRouting
import ulapra.com.plugins.*
import ulapra.com.plugins.configureRouting

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureSignInRouting()
    configureSignUpRouting()
}

object CredentialsStore {
    val credentials: HashMap<String, String> = HashMap()
}
