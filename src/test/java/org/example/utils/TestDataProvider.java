package org.example.utils;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.example.models.LoginData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<LoginData> data =
                Arrays.asList(mapper.readValue(
                        new File("src/test/resources/testdata/Login.json"),
                        LoginData[].class));

        Object[][] result = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }

        return result;
    }
}
