package com.example.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.dataStore.UserPreferencesImpl.Companion.USER_PREFERENCES
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES)

interface IUserPreferences {
    suspend fun saveUserSearch(search: String)
    val userSearchFlow: Flow<String?>
}

class UserPreferencesImpl(private val context: Context) : IUserPreferences {

    companion object {
        const val USER_PREFERENCES = "user_preferences"
        private const val USER_SEARCH = "user_search"
        val USER_SEARCH_KEY = stringPreferencesKey(USER_SEARCH)
    }

    override suspend fun saveUserSearch(search: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_SEARCH_KEY] = search
        }
    }

    override val userSearchFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_SEARCH_KEY]
        }
}