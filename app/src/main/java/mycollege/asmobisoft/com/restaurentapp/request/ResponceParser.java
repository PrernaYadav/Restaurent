package mycollege.asmobisoft.com.restaurentapp.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 6/9/17.
 */

public class ResponceParser {


    @SerializedName("responceCode")
    public String responceCode;

    @SerializedName("responceMessage")
    public String responceMessage;


    public List<ResponceSignup> responce;


  /*  "responceCode": "200",
            "responceMessage": "success",
            "responce": [

*/

}