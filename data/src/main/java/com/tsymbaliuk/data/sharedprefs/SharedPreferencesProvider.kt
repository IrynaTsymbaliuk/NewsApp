package com.tsymbaliuk.data.sharedprefs

import android.content.Context

class SharedPreferencesProviderImpl(private val context: Context) {

    private val prefs = context.applicationContext.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    /*override fun getLanguage() =  gson.fromJson(prefs.getString(LANGUAGE_KEY, ""), LanguageContent::class.java)

    override fun setLanguage(lan: LanguageContent?) {
        prefs.edit().putString(LANGUAGE_KEY, gson.toJson(lan)).apply()
    }*/

    /*override fun getToken() = prefs.getString(AUTH_TOKEN_KEY, "")

    override fun setToken(token: String) {
        prefs.edit().putString(AUTH_TOKEN_KEY, token).apply()
    }*/

    companion object {
        private const val SHARED_PREFS = "tsymbaliuk_israiel_it"
        private const val LANGUAGE_KEY = "language_key"
        private const val AUTH_TOKEN_KEY = "auth_token_key"
    }

}