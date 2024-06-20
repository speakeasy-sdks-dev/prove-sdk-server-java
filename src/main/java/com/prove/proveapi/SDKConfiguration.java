/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.prove.proveapi;

import com.prove.proveapi.hooks.ClientCredentialsHook;
import com.prove.proveapi.utils.Hook.SdkInitData;
import com.prove.proveapi.utils.HTTPClient;
import com.prove.proveapi.utils.RetryConfig;
import com.prove.proveapi.models.components.Security;
import java.util.Optional;

class SDKConfiguration {
    public SecuritySource securitySource;
    
    public Optional<SecuritySource> securitySource() {
        return Optional.ofNullable(securitySource);
    }
    public HTTPClient defaultClient;
      public String serverUrl;
      public String server;
    public String language = "java";
    public String openapiDocVersion = "1.0.0";
    public String sdkVersion = "0.5.4";
    public String genVersion = "2.347.8";
    public String userAgent = "speakeasy-sdk/java 0.5.4 2.347.8 1.0.0 com.prove.proveapi";

    private com.prove.proveapi.utils.Hooks _hooks = createHooks();

    private static com.prove.proveapi.utils.Hooks createHooks() {
        com.prove.proveapi.utils.Hooks hooks = new com.prove.proveapi.utils.Hooks();
        // register client credentials hooks
        ClientCredentialsHook h = new ClientCredentialsHook();
        hooks.registerSdkInit(h);
        hooks.registerBeforeRequest(h);
        hooks.registerAfterError(h);
        return hooks;
    }
    
    public com.prove.proveapi.utils.Hooks hooks() {
        return _hooks;
    }

    public void setHooks(com.prove.proveapi.utils.Hooks hooks) {
        this._hooks = hooks;
    }

    /** 
     * Initializes state (for example hooks).
     **/
    public void initialize() {
        com.prove.proveapi.hooks.SDKHooks.initialize(_hooks);
        // apply the sdk init hook immediately
        SdkInitData data = _hooks.sdkInit(new SdkInitData(serverUrl, defaultClient));
        this.serverUrl = data.baseUrl();
        this.defaultClient = data.client();
    }

    
    
    public Optional<RetryConfig> retryConfig = Optional.empty();
}
