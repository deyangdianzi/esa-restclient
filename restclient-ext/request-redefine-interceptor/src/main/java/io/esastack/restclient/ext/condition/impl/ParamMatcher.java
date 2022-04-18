/*
 * Copyright 2022 OPPO ESA Stack Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.esastack.restclient.ext.condition.impl;

import io.esastack.restclient.RestRequest;
import io.esastack.restclient.ext.condition.MatchResult;

import java.util.Arrays;

public class ParamMatcher {
    private String[] contains;
    private String name;
    private StringMatcher value;

    public ParamMatcher() {
    }

    public MatchResult match(RestRequest request) {
        if (contains != null) {
            for (String contain : contains) {
                if (!request.paramNames().contains(contain)) {
                    return MatchResult.fail("Params don,t contain " + contain);
                }
            }
            return MatchResult.success();
        }
        if (name != null) {
            return value.match(request.getParam(name));
        }

        return MatchResult.fail("Param don't meet expectations("
                + "contains='" + Arrays.toString(contains) + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' + ")!");
    }

    public void setContains(String contains) {
        if (contains == null) {
            this.contains = null;
        } else {
            this.contains = contains.split(",");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(StringMatcher value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParamMatcher{" +
                "contains='" + Arrays.toString(contains) + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
