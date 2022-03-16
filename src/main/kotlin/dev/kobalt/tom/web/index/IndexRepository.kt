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

import dev.kobalt.tom.web.about.AboutRepository
import dev.kobalt.tom.web.blog.BlogRepository
import dev.kobalt.tom.web.contact.ContactRepository
import dev.kobalt.tom.web.legal.LegalRepository
import dev.kobalt.tom.web.link.LinkRepository
import dev.kobalt.tom.web.project.ProjectRepository
import dev.kobalt.tom.web.source.SourceRepository
import dev.kobalt.tom.web.stuff.StuffRepository

object IndexRepository {

    val pageTitle = "Index"
    val pageSubtitle = "Hey, welcome to my website."

    val pageLinks = listOf(
        Triple(AboutRepository.pageRoute, AboutRepository.pageTitle, AboutRepository.pageSubtitle),
        Triple(BlogRepository.pageRoute, BlogRepository.pageTitle, BlogRepository.pageSubtitle),
        Triple(ContactRepository.pageRoute, ContactRepository.pageTitle, ContactRepository.pageSubtitle),
        Triple(LinkRepository.pageRoute, LinkRepository.pageTitle, LinkRepository.pageSubtitle),
        Triple(StuffRepository.pageRoute, StuffRepository.pageTitle, StuffRepository.pageSubtitle),
        Triple(SourceRepository.pageRoute, SourceRepository.pageTitle, SourceRepository.pageSubtitle),
        Triple(ProjectRepository.pageRoute, ProjectRepository.pageTitle, ProjectRepository.pageSubtitle),
        Triple(LegalRepository.pageRoute, LegalRepository.pageTitle, LegalRepository.pageSubtitle)
    )

}