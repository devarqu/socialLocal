package org.compose_projects.socialocal.auth.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.compose_projects.socialocal.auth.data.model.Users
import org.compose_projects.socialocal.common.utils.Constants

@Dao
interface UsersDBDao {
    @Query("SELECT * FROM ${Constants.tableUsers_name}")
    fun getUsers(): Flow<List<Users>>

    @Query("SELECT * FROM ${Constants.tableUsers_name} WHERE id = :id")
    fun getUser(id: Int): Flow<Users>

    @Query("SELECT * FROM ${Constants.tableUsers_name} WHERE user = :username")
    fun getPassword(username: String): Flow<Users>

    @Insert
    suspend fun addUser(user: Users)

    @Update
    suspend fun updateUser(user: Users)

    @Delete
    suspend fun deleteUser(user: Users)

}