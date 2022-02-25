package com.berkt.cryptocrazy.viewmodel

import androidx.lifecycle.ViewModel
import com.berkt.cryptocrazy.model.Crypto
import com.berkt.cryptocrazy.repository.CryptoRepository
import com.berkt.cryptocrazy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
): ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }

}