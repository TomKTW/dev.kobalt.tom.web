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

package dev.kobalt.tom.web.blog

import dev.kobalt.tom.web.database.DatabaseRepository
import dev.kobalt.tom.web.extension.transaction
import dev.kobalt.tom.web.uid.Uid
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

object BlogRepository {

    val pageTitle = "Blog"
    val pageSubtitle = "Things that I wrote."
    val pageEmpty = "There are no entries."
    val pageRoute = "blog/"

    val database get() = DatabaseRepository.main

    fun selectList(): List<BlogEntity> = database.transaction {
        BlogTable.select { BlogTable.visible eq true }
            .orderBy(BlogTable.updateTimestamp, SortOrder.DESC)
            .map { it.toBlogEntity() }
    }

    fun selectItem(uid: Uid): BlogEntity? = database.transaction {
        BlogTable.select { (BlogTable.uid eq uid) and (BlogTable.visible eq true) }.singleOrNull()
            ?.toBlogEntity()
    }

}


