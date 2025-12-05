package org.angelldca.helloworld

import kotlin.js.JsModule


@kotlin.js.ExperimentalWasmJsInterop
@JsModule("@js-joda/timezone")
external object JsJodaTimeZoneModule

private val jsJodaTz = JsJodaTimeZoneModule

actual fun initTimeZones() {
    jsJodaTz // referencia explícita: fuerza el import del módulo
}
