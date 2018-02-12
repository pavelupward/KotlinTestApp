package pavel.project.kotlin.kotlinnexample.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by pavel on 20.10.2017.
 */

class ExampleModel {
    @SerializedName("title")
    var titlePost: String? = null
    @SerializedName("body")
    var bodyPost: String? = null
    @SerializedName("userId")
    var userId: Int? = null
    @SerializedName("id")
    var idPost: Int? = null


}
