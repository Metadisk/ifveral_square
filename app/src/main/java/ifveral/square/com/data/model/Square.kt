package ifveral.square.com.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Square(@field:SerializedName("description") var description: String,
                  @field:SerializedName("name") var name: String,
                  @SerializedName("owner")
                @Expose
                var image: Owner? = null
)
