package org.sopt.at.data.service

import org.sopt.at.data.dto.response.ResponseUserListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TvingService {
    @GET("/api/users")
    fun getListUser(
        @Query("page") page: Int
    ): Call<ResponseUserListDto>
}