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

package dev.kobalt.tom.web.source

import dev.kobalt.tom.web.database.DatabaseRepository

object SourceRepository {

    val pageTitle = "Source"
    val pageSubtitle = "Check out the code used for making this website."
    val pageEmpty = "There are no source code repositories available."
    val pageRoute = "source/"

    val database get() = DatabaseRepository.main

    fun selectList(): List<Triple<String, String, String>> = listOf(
        Triple("dev.kobalt.tom.jvm", "Backend", "Database server where frontend gets the data from."),
        Triple("dev.kobalt.tom.web", "Frontend", "Website server where data from backend is displayed."),
        Triple(
            "more",
            "More",
            "Want to find more source code of things I've worked on? You can find them here, or check source page for each project."
        )
    )

}