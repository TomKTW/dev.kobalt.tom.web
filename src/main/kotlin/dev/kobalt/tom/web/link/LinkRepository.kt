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

package dev.kobalt.tom.web.link

import dev.kobalt.tom.web.database.DatabaseRepository
import dev.kobalt.tom.web.extension.transaction
import dev.kobalt.tom.web.uid.Uid
import org.jetbrains.exposed.sql.LowerCase
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

object LinkRepository {

    val pageTitle = "Links"
    val pageSubtitle = "Other sites that contain stuff."
    val pageEmpty = "There are no links."
    val pageRoute = "link/"

    val database get() = DatabaseRepository.main

    fun selectList(): List<LinkEntity> = database.transaction {
        LinkTable.select { LinkTable.visible eq true }
            .orderBy(LowerCase(LinkTable.title), SortOrder.ASC)
            .map { it.toLinkEntity() }
    }

    fun selectItem(uid: Uid): LinkEntity? = database.transaction {
        LinkTable.select { (LinkTable.uid eq uid) and (LinkTable.visible eq true) }.singleOrNull()
            ?.toLinkEntity()
    }

}