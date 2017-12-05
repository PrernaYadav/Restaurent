package mycollege.asmobisoft.com.restaurentapp.responseparser;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shiv on 9/26/2017.
 */

public class SignupResponseParser {

    @SerializedName("responseCode")
    public String responseCode;

    @SerializedName("responseMessage")
    public String responseMessage;

}
