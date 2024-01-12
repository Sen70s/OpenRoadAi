package com.tuojie.openroadai.model.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.xml.namespace.NamespaceContext

class UserInformationManager (private val context:Context){
    companion object{
        private  val Context.userStore: DataStore<Preferences> by preferencesDataStore("user_store")
        val LOGGED = booleanPreferencesKey("LOGGED")
        val USERNAME = stringPreferencesKey("USERNAME")
        val USERID = intPreferencesKey("USERID")
    }

    val logged: Flow<Boolean> = context.userStore.data.map { it[LOGGED]?: false }
    val userName: Flow<String> = context.userStore.data.map { it[USERNAME]?: "" }
    val userID: Flow<Int> =context.userStore.data.map { it[USERID]?: 0 }

    //储存用户信息
    suspend fun saveData(userName: String,userID:Int){
        context.userStore.edit{
            it[LOGGED] = userName.isEmpty()
            it[USERNAME] = userName
            it[USERID] = userID
        }
    }

    suspend fun clearData(){
        context.userStore.edit{
            it[LOGGED] = false
            it[USERNAME] = ""
            it[USERID] = 0
        }
    }
}