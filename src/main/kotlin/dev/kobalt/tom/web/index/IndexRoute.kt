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

package dev.kobalt.tom.web.index

import dev.kobalt.tom.web.about.aboutRoute
import dev.kobalt.tom.web.blog.blogRoute
import dev.kobalt.tom.web.contact.contactRoute
import dev.kobalt.tom.web.extension.pageArticle
import dev.kobalt.tom.web.extension.pageLink
import dev.kobalt.tom.web.extension.respondHtmlContent
import dev.kobalt.tom.web.legal.legalRoute
import dev.kobalt.tom.web.link.linkRoute
import dev.kobalt.tom.web.project.projectRoute
import dev.kobalt.tom.web.source.sourceRoute
import dev.kobalt.tom.web.stuff.stuffRoute
import io.ktor.application.*
import io.ktor.routing.*

fun Route.indexRoute() {
    route("/") {
        get {
            call.respondHtmlContent(
                title = IndexRepository.pageTitle,
                description = IndexRepository.pageSubtitle
            ) {
                pageArticle(
                    IndexRepository.pageTitle,
                    IndexRepository.pageSubtitle
                ) {
                    IndexRepository.pageLinks.forEach {
                        pageLink(it.second, it.third, it.first)
                    }
                }
            }
        }
        aboutRoute()
        blogRoute()
        contactRoute()
        linkRoute()
        projectRoute()
        stuffRoute()
        sourceRoute()
        legalRoute()
    }
}