/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.copper.util;

import static com.bytechef.component.copper.constant.CopperConstants.BASE_URL;
import static com.bytechef.component.copper.util.CopperUtils.getHeaders;
import static com.bytechef.component.definition.ComponentDSL.option;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Context;
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.Parameters;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Monika Domiter
 */
public class CopperOptionUtils {

    private CopperOptionUtils() {
    }

    private static List<Option<String>> createOptions(ArrayList<LinkedHashMap<String, Object>> value) {
        List<Option<String>> options = new ArrayList<>();

        value.forEach(linkedHashMap -> options.add(
            option(String.valueOf(linkedHashMap.get("name")), String.valueOf(linkedHashMap.get("id")))));

        return options;
    }

    public static List<Option<String>> getActivityTypeOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context) {

        LinkedHashMap<String, ArrayList<LinkedHashMap<String, Object>>> linkedHashMap =
            context
                .http(http -> http.get(BASE_URL + "/activity_types"))
                .headers(getHeaders(connectionParameters))
                .configuration(Context.Http.responseType(Context.Http.ResponseType.JSON))
                .execute()
                .getBody(new Context.TypeReference<>() {});

        List<Option<String>> options = new ArrayList<>();

        linkedHashMap
            .getOrDefault("user", new ArrayList<>())
            .forEach(map -> options.add(option(String.valueOf(map.get("name")), String.valueOf(map.get("id")))));

        return options;
    }

    public static List<Option<String>> getCompanyIdOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context) {

        ArrayList<LinkedHashMap<String, Object>> value = context
            .http(http -> http.post(BASE_URL + "/companies/search"))
            .headers(getHeaders(connectionParameters))
            .configuration(Context.Http.responseType(Context.Http.ResponseType.JSON))
            .execute()
            .getBody(new Context.TypeReference<>() {});

        return createOptions(value);
    }

    public static List<Option<String>> getContactTypesOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context) {

        ArrayList<LinkedHashMap<String, Object>> value = context
            .http(http -> http.get(BASE_URL + "/contact_types"))
            .headers(getHeaders(connectionParameters))
            .configuration(Context.Http.responseType(Context.Http.ResponseType.JSON))
            .execute()
            .getBody(new Context.TypeReference<>() {});

        return createOptions(value);
    }

    public static List<Option<String>> getTagsOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context) {

        ArrayList<LinkedHashMap<String, Object>> value = context
            .http(http -> http.get(BASE_URL + "/tags"))
            .headers(getHeaders(connectionParameters))
            .configuration(Context.Http.responseType(Context.Http.ResponseType.JSON))
            .execute()
            .getBody(new Context.TypeReference<>() {});

        List<Option<String>> options = new ArrayList<>();

        value.forEach(linkedHashMap -> {
            String name = String.valueOf(linkedHashMap.get("name"));

            options.add(option(name, name));
        });

        return options;
    }

    public static List<Option<String>> getUserOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context) {

        ArrayList<LinkedHashMap<String, Object>> value = context
            .http(http -> http.post(BASE_URL + "/users/search"))
            .headers(getHeaders(connectionParameters))
            .configuration(Context.Http.responseType(Context.Http.ResponseType.JSON))
            .execute()
            .getBody(new Context.TypeReference<>() {});

        return createOptions(value);
    }
}
