package org.angelldca.helloworld.infrastructure

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js

actual fun platformHttpClient(): HttpClient =
    configureClient(HttpClient(Js))