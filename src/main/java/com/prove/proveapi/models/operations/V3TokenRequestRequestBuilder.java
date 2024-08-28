/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.prove.proveapi.models.operations;

import com.prove.proveapi.models.components.V3TokenRequest;
import com.prove.proveapi.utils.Utils;
import java.util.Optional;

public class V3TokenRequestRequestBuilder {

    private Optional<? extends V3TokenRequest> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallV3TokenRequest sdk;

    public V3TokenRequestRequestBuilder(SDKMethodInterfaces.MethodCallV3TokenRequest sdk) {
        this.sdk = sdk;
    }
                
    public V3TokenRequestRequestBuilder request(com.prove.proveapi.models.components.V3TokenRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public V3TokenRequestRequestBuilder request(java.util.Optional<? extends com.prove.proveapi.models.components.V3TokenRequest> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public V3TokenRequestResponse call() throws Exception {

        return sdk.v3TokenRequest(
            request);
    }
}
