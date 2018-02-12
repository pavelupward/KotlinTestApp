package pavel.project.kotlin.kotlinnexample.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by pavel on 21.10.2017.
 */

class PhotoModel {
    @SerializedName("format")
    @Expose
    var format: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("filename")
    @Expose
    var filename: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("author_url")
    @Expose
    var authorUrl: String? = null
    @SerializedName("post_url")
    @Expose
    var postUrl: String? = null


}
