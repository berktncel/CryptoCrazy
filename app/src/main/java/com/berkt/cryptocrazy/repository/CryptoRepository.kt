package com.berkt.cryptocrazy.repository

import com.berkt.cryptocrazy.model.Crypto
import com.berkt.cryptocrazy.model.CryptoList
import com.berkt.cryptocrazy.service.CryptoAPI
import com.berkt.cryptocrazy.util.Constants.API_KEY
import com.berkt.cryptocrazy.util.Constants.CALL_ATTRIBUTES
import com.berkt.cryptocrazy.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch (e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY, id, CALL_ATTRIBUTES)
        } catch (e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

}