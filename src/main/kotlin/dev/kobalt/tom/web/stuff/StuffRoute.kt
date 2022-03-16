/*
 * dev.kobalt.tom
 * Copyright (C) 2022 Tom.K
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.kobalt.tom.web.stuff

import dev.kobalt.tom.web.extension.pageArticle
import dev.kobalt.tom.web.extension.pageLink
import dev.kobalt.tom.web.extension.respondHtmlContent
import dev.kobalt.tom.web.uid.toUid
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.p
import java.io.File

fun Route.stuffRoute() {
    route(StuffRepository.pageRoute) {
        get {
            call.respondHtmlContent(
                title = StuffRepository.pageTitle,
                description = StuffRepository.pageSubtitle
            ) {
                pageArticle(
                    StuffRepository.pageTitle,
                    StuffRepository.pageSubtitle
                ) {
                    StuffRepository.selectList().takeIf { it.isNotEmpty() }?.forEach { entity ->
                        pageLink(entity.title, entity.content, "entry/${entity.uid}/")
                    } ?: run {
                        p { text(StuffRepository.pageEmpty) }
                    }
                }
            }
        }
        route("entry/") {
            get { call.respondRedirect("..") }
            route("{uid}/") {
                get {
                    call.parameters["uid"]?.toUid()?.let { StuffRepository.selectItem(it) }?.let { entity ->
                        val file = File(entity.link)
                        call.response.header(
                            HttpHeaders.ContentDisposition,
                            ContentDisposition.Attachment.withParameter(
                                ContentDisposition.Parameters.FileName,
                                file.name
                            )
                                .toString()
                        )
                        call.respondFile(file)
                    } ?: call.respond(HttpStatusCode.NotFound)
                }
            }
        }
    }
}