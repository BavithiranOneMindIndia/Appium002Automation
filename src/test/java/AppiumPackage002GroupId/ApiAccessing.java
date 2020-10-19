package AppiumPackage002GroupId;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class ApiAccessing {


    public String apiGetProcessing(String apiUrl) {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {
            // Define a HttpGet request; You can choose between HttpPost, HttpDelete or
            // HttpPut also.
            // Choice depends on type of method you will be invoking.
            HttpGet getRequest = new HttpGet(apiUrl);

            // Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");

            // HttpParams params = new BasicHttpParams();
            // params.setParameter(name, value);

            // Send the request; It will immediately return the response in HttpResponse
            // object
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
}
