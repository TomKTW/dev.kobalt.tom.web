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

package dev.kobalt.tom.web.about.link

import dev.kobalt.tom.web.config.ConfigRepository
import dev.kobalt.tom.web.extension.fromCsv

object AboutLinkRepository {

    val pageTitle = "Links"
    val pageSubtitle = "Places where you could find me."
    val pageRoute = "link/"

    fun selectList() = ConfigRepository.selectItemByKey("aboutLinks")?.value.orEmpty().fromCsv().map {
        Triple(it[0], it[1], it[2])
    }.sortedBy { it.first }

}