/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.prove.proveapi.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.prove.proveapi.utils.LazySingletonValue;
import com.prove.proveapi.utils.SpeakeasyMetadata;
import com.prove.proveapi.utils.Utils;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class Security {

    @SpeakeasyMetadata("security:scheme=true,type=oauth2,subtype=client_credentials,name=clientID")
    private Optional<? extends String> clientID;

    @SpeakeasyMetadata("security:scheme=true,type=oauth2,subtype=client_credentials,name=clientSecret")
    private Optional<? extends String> clientSecret;

    private Optional<? extends String> tokenURL;

    @JsonCreator
    public Security(
            Optional<? extends String> clientID,
            Optional<? extends String> clientSecret) {
        Utils.checkNotNull(clientID, "clientID");
        Utils.checkNotNull(clientSecret, "clientSecret");
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.tokenURL = Builder._SINGLETON_VALUE_TokenURL.value();
    }
    
    public Security() {
        this(Optional.empty(), Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> clientID() {
        return (Optional<String>) clientID;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> clientSecret() {
        return (Optional<String>) clientSecret;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> tokenURL() {
        return (Optional<String>) tokenURL;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public Security withClientID(String clientID) {
        Utils.checkNotNull(clientID, "clientID");
        this.clientID = Optional.ofNullable(clientID);
        return this;
    }

    public Security withClientID(Optional<? extends String> clientID) {
        Utils.checkNotNull(clientID, "clientID");
        this.clientID = clientID;
        return this;
    }

    public Security withClientSecret(String clientSecret) {
        Utils.checkNotNull(clientSecret, "clientSecret");
        this.clientSecret = Optional.ofNullable(clientSecret);
        return this;
    }

    public Security withClientSecret(Optional<? extends String> clientSecret) {
        Utils.checkNotNull(clientSecret, "clientSecret");
        this.clientSecret = clientSecret;
        return this;
    }
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Security other = (Security) o;
        return 
            java.util.Objects.deepEquals(this.clientID, other.clientID) &&
            java.util.Objects.deepEquals(this.clientSecret, other.clientSecret) &&
            java.util.Objects.deepEquals(this.tokenURL, other.tokenURL);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            clientID,
            clientSecret,
            tokenURL);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Security.class,
                "clientID", clientID,
                "clientSecret", clientSecret,
                "tokenURL", tokenURL);
    }
    
    public final static class Builder {
 
        private Optional<? extends String> clientID = Optional.empty();
 
        private Optional<? extends String> clientSecret = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder clientID(String clientID) {
            Utils.checkNotNull(clientID, "clientID");
            this.clientID = Optional.ofNullable(clientID);
            return this;
        }

        public Builder clientID(Optional<? extends String> clientID) {
            Utils.checkNotNull(clientID, "clientID");
            this.clientID = clientID;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            Utils.checkNotNull(clientSecret, "clientSecret");
            this.clientSecret = Optional.ofNullable(clientSecret);
            return this;
        }

        public Builder clientSecret(Optional<? extends String> clientSecret) {
            Utils.checkNotNull(clientSecret, "clientSecret");
            this.clientSecret = clientSecret;
            return this;
        }
        
        public Security build() {
            return new Security(
                clientID,
                clientSecret);
        }

        private static final LazySingletonValue<Optional<? extends String>> _SINGLETON_VALUE_TokenURL =
                new LazySingletonValue<>(
                        "TokenURL",
                        "\"/token\"",
                        new TypeReference<Optional<? extends String>>() {});
    }
}

