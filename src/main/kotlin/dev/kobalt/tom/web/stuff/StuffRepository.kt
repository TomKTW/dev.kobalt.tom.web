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

import dev.kobalt.tom.web.database.DatabaseRepository
import dev.kobalt.tom.web.extension.transaction
import dev.kobalt.tom.web.uid.Uid
import org.jetbrains.exposed.sql.LowerCase
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

object StuffRepository {

    val pageTitle = "Stuff"
    val pageSubtitle = "Things that I didn't work on, but you could check them out."
    val pageEmpty = "There are no things."
    val pageRoute = "stuff/"

    val database get() = DatabaseRepository.main

    fun selectList(): List<StuffEntity> = database.transaction {
        StuffTable.select { StuffTable.visible eq true }
            .orderBy(LowerCase(StuffTable.title), SortOrder.ASC)
            .map { it.toStuffEntity() }
    }

    fun selectItem(uid: Uid): StuffEntity? = database.transaction {
        StuffTable.select {
            (StuffTable.uid eq uid) and (StuffTable.visible eq true)
        }.singleOrNull()?.toStuffEntity()
    }

}


