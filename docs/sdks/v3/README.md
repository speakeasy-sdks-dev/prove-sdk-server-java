# V3
(*v3()*)

## Overview

### Available Operations

* [v3TokenRequest](#v3tokenrequest) - Request OAuth token.
* [v3ChallengeRequest](#v3challengerequest) - Submit challenge.
* [v3CompleteRequest](#v3completerequest) - Complete flow.
* [v3StartRequest](#v3startrequest) - Start flow.
* [v3ValidateRequest](#v3validaterequest) - Validate phone number.

## v3TokenRequest

Send this request to request the OAuth token.

### Example Usage

```java
package hello.world;

import com.prove.proveapi.Proveapi;
import com.prove.proveapi.models.components.V3TokenRequest;
import com.prove.proveapi.models.errors.Error400;
import com.prove.proveapi.models.errors.Error;
import com.prove.proveapi.models.operations.V3TokenRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error400, Error, Exception {

        Proveapi sdk = Proveapi.builder()
            .build();

        V3TokenRequest req = V3TokenRequest.builder()
                .clientId("customer_id")
                .clientSecret("secret")
                .grantType("client_credentials")
                .build();

        V3TokenRequestResponse res = sdk.v3().v3TokenRequest()
                .request(req)
                .call();

        if (res.v3TokenResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [V3TokenRequest](../../models/shared/V3TokenRequest.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[V3TokenRequestResponse](../../models/operations/V3TokenRequestResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/Error400 | 400                    | application/json       |
| models/errors/Error    | 500                    | application/json       |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## v3ChallengeRequest

Send this request to submit challenge information. Either a DOB or last 4 of SSN needs to be submitted if neither was submitted to the /start endpoint (challenge fields submitted to this endpoint will overwrite the /start endpoint fields submitted). It will return a correlation ID, user information, and the next step to call in the flow. This capability is only available in Pre-Fill®, it's not available in Prove Identity®. You'll notice that when using Prove Identity®, if /validate is successful, it will then return `v3-complete` as one of the keys in the `Next` field map instead of `v3-challenge`.

### Example Usage

```java
package hello.world;

import com.prove.proveapi.Proveapi;
import com.prove.proveapi.models.components.Security;
import com.prove.proveapi.models.components.V3ChallengeRequest;
import com.prove.proveapi.models.errors.Error400;
import com.prove.proveapi.models.errors.Error;
import com.prove.proveapi.models.operations.V3ChallengeRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error400, Error, Exception {

        Proveapi sdk = Proveapi.builder()
                .security(Security.builder()
                    .clientID("<YOUR_CLIENT_ID_HERE>")
                    .clientSecret("<YOUR_CLIENT_SECRET_HERE>")
                    .build())
            .build();

        V3ChallengeRequest req = V3ChallengeRequest.builder()
                .correlationId("713189b8-5555-4b08-83ba-75d08780aebd")
                .dob("1981-01")
                .ssn("0596")
                .build();

        V3ChallengeRequestResponse res = sdk.v3().v3ChallengeRequest()
                .request(req)
                .call();

        if (res.v3ChallengeResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [V3ChallengeRequest](../../models/shared/V3ChallengeRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[V3ChallengeRequestResponse](../../models/operations/V3ChallengeRequestResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/Error400 | 400                    | application/json       |
| models/errors/Error    | 500                    | application/json       |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## v3CompleteRequest

Send this request to verify the user and complete the flow. It will return a correlation ID, user information, and the next step to call in the flow. There is a validation check that requires at least first + last name or SSN passed in, else an HTTP 400 is returned. Additionally, specific to the Pre-Fill® or Prove Identity® with KYC use case, you need to pass in first name, last name, DOB and SSN (or address) to ensure you receive back the KYC elements and correct CIP values.

### Example Usage

```java
package hello.world;

import com.prove.proveapi.Proveapi;
import com.prove.proveapi.models.components.Security;
import com.prove.proveapi.models.components.V3CompleteAddressEntryRequest;
import com.prove.proveapi.models.components.V3CompleteIndividualRequest;
import com.prove.proveapi.models.components.V3CompleteRequest;
import com.prove.proveapi.models.errors.Error400;
import com.prove.proveapi.models.errors.Error;
import com.prove.proveapi.models.operations.V3CompleteRequestResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Error400, Error, Exception {

        Proveapi sdk = Proveapi.builder()
                .security(Security.builder()
                    .clientID("<YOUR_CLIENT_ID_HERE>")
                    .clientSecret("<YOUR_CLIENT_SECRET_HERE>")
                    .build())
            .build();

        V3CompleteRequest req = V3CompleteRequest.builder()
                .correlationId("713189b8-5555-4b08-83ba-75d08780aebd")
                .individual(V3CompleteIndividualRequest.builder()
                    .addresses(List.of(
                        V3CompleteAddressEntryRequest.builder()
                            .address("39 South Trail")
                            .city("San Antonio")
                            .extendedAddress("Apt 23")
                            .postalCode("78285")
                            .region("TX")
                            .build(),
                        V3CompleteAddressEntryRequest.builder()
                            .address("4861 Jay Junction")
                            .city("Boston")
                            .extendedAddress("Apt 78")
                            .postalCode("02208")
                            .region("MS")
                            .build()))
                    .dob("1981-01-17")
                    .emailAddresses(List.of(
                        "jdoe@example.com",
                        "dsmith@example.com"))
                    .firstName("Tod")
                    .lastName("Weedall")
                    .ssn("265228370")
                    .build())
                .build();

        V3CompleteRequestResponse res = sdk.v3().v3CompleteRequest()
                .request(req)
                .call();

        if (res.v3CompleteResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [V3CompleteRequest](../../models/shared/V3CompleteRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[V3CompleteRequestResponse](../../models/operations/V3CompleteRequestResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/Error400 | 400                    | application/json       |
| models/errors/Error    | 500                    | application/json       |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## v3StartRequest

Send this request to start a Prove flow. It will return a correlation ID and an authToken for the client SDK.

### Example Usage

```java
package hello.world;

import com.prove.proveapi.Proveapi;
import com.prove.proveapi.models.components.Security;
import com.prove.proveapi.models.components.V3StartRequest;
import com.prove.proveapi.models.errors.Error400;
import com.prove.proveapi.models.errors.Error;
import com.prove.proveapi.models.operations.V3StartRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error400, Error, Exception {

        Proveapi sdk = Proveapi.builder()
                .security(Security.builder()
                    .clientID("<YOUR_CLIENT_ID_HERE>")
                    .clientSecret("<YOUR_CLIENT_SECRET_HERE>")
                    .build())
            .build();

        V3StartRequest req = V3StartRequest.builder()
                .flowType("mobile")
                .dob("1981-01")
                .emailAddress("mpinsonm@dyndns.org")
                .finalTargetUrl("https://www.example.com/landing-page")
                .ipAddress("10.0.0.1")
                .phoneNumber("2001001695")
                .smsMessage("\"Your code is: ####.\"")
                .ssn("0596")
                .build();

        V3StartRequestResponse res = sdk.v3().v3StartRequest()
                .request(req)
                .call();

        if (res.v3StartResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [V3StartRequest](../../models/shared/V3StartRequest.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[V3StartRequestResponse](../../models/operations/V3StartRequestResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/Error400 | 400                    | application/json       |
| models/errors/Error    | 500                    | application/json       |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## v3ValidateRequest

Send this request to check the phone number entered/discovered earlier in the flow is validated. It will return a correlation ID and the next step.

### Example Usage

```java
package hello.world;

import com.prove.proveapi.Proveapi;
import com.prove.proveapi.models.components.Security;
import com.prove.proveapi.models.components.V3ValidateRequest;
import com.prove.proveapi.models.errors.Error400;
import com.prove.proveapi.models.errors.Error;
import com.prove.proveapi.models.operations.V3ValidateRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error400, Error, Exception {

        Proveapi sdk = Proveapi.builder()
                .security(Security.builder()
                    .clientID("<YOUR_CLIENT_ID_HERE>")
                    .clientSecret("<YOUR_CLIENT_SECRET_HERE>")
                    .build())
            .build();

        V3ValidateRequest req = V3ValidateRequest.builder()
                .correlationId("713189b8-5555-4b08-83ba-75d08780aebd")
                .build();

        V3ValidateRequestResponse res = sdk.v3().v3ValidateRequest()
                .request(req)
                .call();

        if (res.v3ValidateResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [V3ValidateRequest](../../models/shared/V3ValidateRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[V3ValidateRequestResponse](../../models/operations/V3ValidateRequestResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/Error400 | 400                    | application/json       |
| models/errors/Error    | 500                    | application/json       |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |