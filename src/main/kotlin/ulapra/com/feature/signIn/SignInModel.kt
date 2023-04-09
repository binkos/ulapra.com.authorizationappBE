package ulapra.com.feature.signIn

import kotlinx.serialization.Serializable

@Serializable
data class SignInReceiveRemote(
    val email: String,
    val password: String
)

@Serializable
data class SignInResponseRemote(
    val token: String
)