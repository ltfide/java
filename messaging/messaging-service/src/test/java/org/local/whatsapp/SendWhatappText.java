package org.local.whatsapp;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendWhatappText {

    private static final String BASE_URL = "https://4mgv91.api.infobip.com";
    private static final String API_KEY = "App afdd5ef0edd5fecc7e97fe170c5134b9-de543e44-6bcb-4a79-b85f-9b8a527597a7";
    private static final String MEDIA_TYPE = "application/json";

    private static final String SENDER = "447860099299";
    private static final String RECIPIENT = "6287789134047";

    private static Request prepareHttpRequest(RequestBody body) {
        return new Request.Builder()
                .url(String.format("%s/whatsapp/1/message/template", BASE_URL))
                .method("POST", body)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", MEDIA_TYPE)
                .addHeader("Accept", MEDIA_TYPE)
                .build();
    }

    @Test
    void sendTemplateMessageBasic() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String bodyJson = String.format(
                "{\n" +
                        "  \"messages\": [\n" +
                        "    {\n" +
                        "        \"from\": \"%s\",\n" +
                        "        \"to\": \"%s\",\n" +
                        "        \"content\": {\n" +
                        "          \"templateName\": \"registration_success\",\n" +
                        "          \"templateData\": {\n" +
                        "            \"body\": {\n" +
                        "              \"placeholders\": [\n" +
                        "                \"sender\",\n" +
                        "                \"message\",\n" +
                        "                \"delivered\",\n" +
                        "                \"testing\"\n" +
                        "              ]\n" +
                        "            },\n" +
                        "            \"header\": {\n" +
                        "              \"type\": \"IMAGE\",\n" +
                        "              \"mediaUrl\": \"https://api.infobip.com/ott/1/media/infobipLogo\"\n" +
                        "            },\n" +
                        "            \"buttons\": [\n" +
                        "              {\n" +
                        "                \"type\": \"QUICK_REPLY\",\n" +
                        "                \"parameter\": \"yes-payload\"\n" +
                        "              },\n" +
                        "              {\n" +
                        "                \"type\": \"QUICK_REPLY\",\n" +
                        "                \"parameter\": \"no-payload\"\n" +
                        "              },\n" +
                        "              {\n" +
                        "                \"type\": \"QUICK_REPLY\",\n" +
                        "                \"parameter\": \"later-payload\"\n" +
                        "              }\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        \"language\": \"en\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}",
                SENDER, RECIPIENT);

        RequestBody body = RequestBody.create(bodyJson, MediaType.parse(MEDIA_TYPE));
        System.out.println(bodyJson);
        Request request = prepareHttpRequest(body);
        Response response = client.newCall(request).execute();

        System.out.println("HTTP status code: " + response.code());
        System.out.println("Response body: " + response.body().string());
    }
}
