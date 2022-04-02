package io.esastack.restclient.ext.condition.impl;

import esa.commons.Checks;
import io.esastack.restclient.RestRequest;
import io.esastack.restclient.ext.condition.MatchResult;
import io.esastack.restclient.ext.condition.RequestRedefineCondition;

public class AuthorityCondition implements RequestRedefineCondition {

    private final StringMatcher matcher;

    public AuthorityCondition(StringMatcher matcher) {
        Checks.checkNotNull(matcher, "matcher");
        this.matcher = matcher;
    }

    @Override
    public MatchResult match(RestRequest request) {
        return matcher.match(request.uri().netURI().getAuthority());
    }

    @Override
    public String toString() {
        return "AuthorityCondition{" +
                "matcher=" + matcher +
                '}';
    }
}
