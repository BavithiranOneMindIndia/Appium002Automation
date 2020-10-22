package AppiumPackage002GroupId;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import javax.json.*;

public class ApiAccessing {

    public String apiGetProcessing(String apiUrl) {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {

            HttpGet getRequest = new HttpGet(apiUrl);

            // Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);

            // verify the valid error code first
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

            // Now pull back the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);
            return apiOutput;
            // Lets see what we got from API
            // System.out.println(apiOutput);
        } catch (Exception exception) {
            System.out.println("Api got failed");
            return null;
        }
    }

    public String apiPostProcessing(String apiUrl , String jsonBody) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost postRequest = new HttpPost(apiUrl);

            StringEntity input = new StringEntity(jsonBody);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP post error code : " + statusCode);
            }

            // Now pull back the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);
            return apiOutput;
            // Lets see what we got from API
            // System.out.println(apiOutput);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
            System.out.println("Post Api got failed");
            return null;
        }

    }

   
}
