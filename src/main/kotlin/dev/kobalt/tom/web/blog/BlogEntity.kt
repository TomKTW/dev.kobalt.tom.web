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

import dev.kobalt.tom.web.uid.Uid
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class BlogEntity(
    val id: Long,
    val uid: Uid,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val visible: Boolean
) {

    val createdAtFormatted: String
        get() = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))

    val updatedAtFormatted: String
        get() = updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))

}