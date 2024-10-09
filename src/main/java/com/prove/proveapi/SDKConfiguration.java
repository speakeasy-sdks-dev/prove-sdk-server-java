/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.prove.proveapi;

import com.prove.proveapi.hooks.ClientCredentialsHook;
import com.prove.proveapi.hooks.SDKHooks;
import com.prove.proveapi.utils.HTTPClient;
import com.prove.proveapi.utils.Hook.SdkInitData;
import com.prove.proveapi.utils.Hooks;
import com.prove.proveapi.utils.RetryConfig;
import java.lang.String;
import java.util.Optional;

class SDKConfiguration {
    public SecuritySource securitySource;
    
    public Optional<SecuritySource> securitySource() {
        return Optional.ofNullable(securitySource);
    }
    public HTTPClient defaultClient;
    public String serverUrl;
    public String server;
    private static final String LANGUAGE = "java";
    public static final String OPENAPI_DOC_VERSION = "1.0.0";
    public static final String SDK_VERSION = "0.10.0";
    public static final String GEN_VERSION = "2.437.1";
    private static final String BASE_PACKAGE = "com.prove.proveapi";
    public static final String USER_AGENT = 
            String.format("speakeasy-sdk/%s %s %s %s %s", 
                LANGUAGE, SDK_VERSION, GEN_VERSION, OPENAPI_DOC_VERSION, BASE_PACKAGE);

    private Hooks _hooks = createHooks();

    private static Hooks createHooks() {
        Hooks hooks = new Hooks();
        // register client credentials hooks
        ClientCredentialsHook h = new ClientCredentialsHook();
        hooks.registerSdkInit(h);
        hooks.registerBeforeRequest(h);
        hooks.registerAfterError(h);
        return hooks;
    }
    
    public Hooks hooks() {
        return _hooks;
    }

    public void setHooks(Hooks hooks) {
        this._hooks = hooks;
    }

    /** 
     * Initializes state (for example hooks).
     **/
    public void initialize() {
        SDKHooks.initialize(_hooks);
        // apply the sdk init hook immediately
        SdkInitData data = _hooks.sdkInit(new SdkInitData(serverUrl, defaultClient));
        this.serverUrl = data.baseUrl();
        this.defaultClient = data.client();
    }

    
    
    public Optional<RetryConfig> retryConfig = Optional.empty();
}
