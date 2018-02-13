package pavel.project.kotlin.kotlinnexample.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by pavel on 20.10.2017.
 */

data class ExampleModel(
        @SerializedName("title")
        var titlePost: String,
        @SerializedName("body")
        var bodyPost: String,
        @SerializedName("userId")
        var userId: Int,
        @SerializedName("id")
        var idPost: Int
)
