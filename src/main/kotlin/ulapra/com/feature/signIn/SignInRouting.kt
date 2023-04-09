package ulapra.com.feature.signIn

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ulapra.com.CredentialsStore

fun Application.configureSignInRouting() {
    routing {
        post("accounts/signIn") {
            val credentials = call.receive<SignInReceiveRemote>()
            val password = CredentialsStore.credentials[credentials.email]
            if (password == credentials.password) {
                call.respond(SignInResponseRemote(credentials.toString()))

            } else {
                call.respond(HttpStatusCode.BadRequest, "Invalid credentials")

            }
        }
    }
}