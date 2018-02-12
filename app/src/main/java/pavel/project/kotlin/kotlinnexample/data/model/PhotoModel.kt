package pavel.project.kotlin.kotlinnexample.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by pavel on 21.10.2017.
 */

data class PhotoModel(
        @SerializedName("format")
        @Expose
        var format: String,
        @SerializedName("width")
        @Expose
        var width: Int,
        @SerializedName("height")
        @Expose
        var height: Int,
        @SerializedName("filename")
        @Expose
        var filename: String,
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("author")
        @Expose
        var author: String,
        @SerializedName("author_url")
        @Expose
        var authorUrl: String,
        @SerializedName("post_url")
        @Expose
        var postUrl: String? = null)



