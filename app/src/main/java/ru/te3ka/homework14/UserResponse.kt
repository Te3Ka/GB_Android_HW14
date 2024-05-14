package ru.te3ka.homework14

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "results") val results: List<User>,
)

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "gender") val gender: String,
    @Json(name = "name") val name: UserName,
    @Json(name = "location") val location: UserLocation,
    @Json(name = "email") val email: String,
    @Json(name = "dob") val dob: UserDOB,
    @Json(name = "phone") val phone: String,
    @Json(name = "cell") val cell: String,
    @Json(name = "picture") val picture: UserPicture,
)

@JsonClass(generateAdapter = true)
data class UserName(
    @Json(name = "title") val title: String,
    @Json(name = "first") val first: String,
    @Json(name = "last") val last: String
)

@JsonClass(generateAdapter = true)
data class UserLocation(
    @Json(name = "city") val city: String,
    @Json(name = "state") val state: String,
    @Json(name = "country") val country: String,
)

@JsonClass(generateAdapter = true)
data class UserDOB(
    @Json(name = "date") val date: String,
    @Json(name = "age") val age: Int
)

@JsonClass(generateAdapter = true)
data class UserPicture(
    @Json(name = "large") val large: String,
)