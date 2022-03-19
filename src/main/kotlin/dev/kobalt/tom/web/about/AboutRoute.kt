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

package dev.kobalt.tom.web.about

import dev.kobalt.tom.web.about.biography.aboutBiographyRoute
import dev.kobalt.tom.web.about.link.aboutLinkRoute
import dev.kobalt.tom.web.about.website.aboutWebsiteRoute
import dev.kobalt.tom.web.extension.pageArticle
import dev.kobalt.tom.web.extension.pageLink
import dev.kobalt.tom.web.extension.respondHtmlContent
import io.ktor.application.*
import io.ktor.routing.*

fun Route.aboutRoute() {
    route(AboutRepository.pageRoute) {
        get {
            call.respondHtmlContent(
                title = AboutRepository.pageTitle,
                description = AboutRepository.pageSubtitle
            ) {
                pageArticle(
                    AboutRepository.pageTitle,
                    AboutRepository.pageSubtitle
                ) {
                    AboutRepository.pageLinks.forEach {
                        pageLink(it.second, it.third, it.first)
                    }
                }
            }
        }
        aboutBiographyRoute()
        aboutLinkRoute()
        aboutWebsiteRoute()
    }
}
