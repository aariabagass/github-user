package com.ariabagas.githubuserapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ariabagas.githubuserapp.models.FavoriteUser

@Database(
    entities = [FavoriteUser::class],
    version = 1
)
abstract class UserDB: RoomDatabase() {
    abstract fun favoriteUserDao(): FavoriteUserDao

    companion object {
        private var INSTANCE: UserDB? = null
        fun getDatabase(context: Context): UserDB? {
            if (INSTANCE == null) {
                synchronized(UserDB::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDB::class.java, "user_database").build()
                }
            }
            return INSTANCE
        }
    }
}