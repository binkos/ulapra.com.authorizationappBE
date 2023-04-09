package ulapra.com.feature.signUp

import kotlinx.serialization.Serializable

@Serializable
data class SignUpReceiveRemote(
    val email: String,
    val password: String
)

@Serializable
data class SignUpResponseRemote(
    val token: String
)