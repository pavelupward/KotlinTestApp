/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pavel.project.kotlin.kotlinnexample.data.mapper

import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.data.model.ExampleModel
import pavel.project.kotlin.kotlinnexample.data.model.PhotoModel
import java.util.*

class UserEntityDataMapper {

    /**
     * in a real project there will be another mapper
     */

    fun transform(exampleModels: List<ExampleModel>, photoModels: List<PhotoModel>): List<Profile> {
        val userList = ArrayList<Profile>()
        for (i in exampleModels.indices) {
            val prof = Profile()
            prof.exModel = exampleModels[i]
            prof.photoModel = photoModels[i]
            userList.add(prof)
        }
        return userList
    }

}
