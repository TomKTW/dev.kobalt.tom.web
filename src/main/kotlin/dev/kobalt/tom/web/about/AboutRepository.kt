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

import dev.kobalt.tom.web.about.biography.AboutBiographyRepository
import dev.kobalt.tom.web.about.link.AboutLinkRepository
import dev.kobalt.tom.web.about.website.AboutWebsiteRepository

object AboutRepository {

    val pageTitle = "About"
    val pageSubtitle = "More about myself or this website."
    val pageRoute = "about/"
    val pageLinks = listOf(
        Triple(
            AboutBiographyRepository.pageRoute,
            AboutBiographyRepository.pageTitle,
            AboutBiographyRepository.pageSubtitle
        ),
        Triple(AboutWebsiteRepository.pageRoute, AboutWebsiteRepository.pageTitle, AboutWebsiteRepository.pageSubtitle),
        Triple(AboutLinkRepository.pageRoute, AboutLinkRepository.pageTitle, AboutLinkRepository.pageSubtitle)
    )

}