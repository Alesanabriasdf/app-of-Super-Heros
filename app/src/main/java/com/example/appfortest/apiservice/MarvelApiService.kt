package com.example.appfortest.apiservice

import com.example.appfortest.model.datafromjson.GlobalDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    @GET(AppConstants.LIST_END_POINT)
    suspend fun getSuperHero(
        @Query("limit") limit: String,
        @Query("apikey") publicKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    )
            : Response<GlobalDto>
}