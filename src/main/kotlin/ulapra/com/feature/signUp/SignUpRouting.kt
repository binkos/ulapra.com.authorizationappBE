package ulapra.com.feature.signUp

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ulapra.com.CredentialsStore

fun Application.configureSignUpRouting() {
    routing {

        post("accounts/signUp") {
            val credentials = call.receive<SignUpReceiveRemote>()
            val isUserExists = CredentialsStore.credentials.containsKey(credentials.email)
            if (isUserExists) {
                call.respond(HttpStatusCode.BadRequest, "User with this email already exists")
            } else {
                call.respond(SignUpResponseRemote(credentials.toString()))
            }
        }
    }
}