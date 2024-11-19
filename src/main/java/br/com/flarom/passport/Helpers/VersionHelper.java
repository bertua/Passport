package br.com.flarom.passport.Helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VersionHelper {
    private String localVersion = "1.0-SNAPSHOT"; // current version, manually change on every release for now :(
    private String apiUrl = "https://api.github.com/repos/flarom/passport/releases/latest";
    
    public String getLocalVersion(){
        return this.localVersion;
    }
    
    // returns the tag name of the last version uploaded as a github release
    public String getLatestVersion() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/vnd.github.v3+json");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        String responseBody = response.toString();
        String version = responseBody.split("\"tag_name\":\"")[1].split("\"")[0];
        return version;
    }
    
    // compares if localVersion is equals to getLatestVersion(). if true, probably the client is outdated
    public boolean isVersionDifferent(String localVersion) throws Exception {
        String latestVersion = getLatestVersion();
        return !localVersion.equals(latestVersion);
    }
}
