package com.example.appfortest.model.datafromjson

import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.Result

data class Data (
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Result>
)