package com.dev.opendelivery.order.api.interfaces;

import com.dev.opendelivery.order.model.*;
import com.dev.opendelivery.order.model.vo.OrderConfirmVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("pedidos")
@Tag(name = "Pedidos", description = "Requisições da API de Pedidos")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface IOrderController {

    @Operation(summary = "View the details of an order.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Order returning success.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                               "id": "string",
                                               "type": "DELIVERY",
                                               "displayId": "string",
                                               "sourceAppId": "string",
                                               "createdAt": "2019-08-24T14:15:22Z",
                                               "orderTiming": "INSTANT",
                                               "preparationStartDateTime": "2019-08-24T14:15:22Z",
                                               "merchant": {
                                                 "id": "22815773000169-dbc7e35a-c936-4665-9e13-eb55eb8b6824",
                                                 "name": "Pizza Plaza"
                                               },
                                               "items": [
                                                 {
                                                   "id": "string",
                                                   "index": 0,
                                                   "name": "string",
                                                   "externalCode": "string",
                                                   "unit": "UNIT",
                                                   "ean": "string",
                                                   "quantity": 0,
                                                   "specialInstructions": "string",
                                                   "unitPrice": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "optionsPrice": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "totalPrice": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "options": [
                                                     {
                                                       "index": 0,
                                                       "id": "string",
                                                       "name": "string",
                                                       "externalCode": "string",
                                                       "unit": "string",
                                                       "ean": "string",
                                                       "quantity": 0,
                                                       "unitPrice": {
                                                         "value": 40,
                                                         "currency": "BRL"
                                                       },
                                                       "totalPrice": {
                                                         "value": 40,
                                                         "currency": "BRL"
                                                       },
                                                       "specialInstructions": "string"
                                                     }
                                                   ]
                                                 }
                                               ],
                                               "otherFees": [
                                                 {
                                                   "name": "string",
                                                   "type": "DELIVERY_FEE",
                                                   "receivedBy": "MARKETPLACE",
                                                   "receiverDocument": "string",
                                                   "price": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "observation": "string"
                                                 }
                                               ],
                                               "discounts": [
                                                 {
                                                   "amount": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "target": "CART",
                                                   "targetId": "string",
                                                   "sponsorshipValues": [
                                                     {
                                                       "name": "MARKETPLACE",
                                                       "amount": {
                                                         "value": 40,
                                                         "currency": "BRL"
                                                       }
                                                     }
                                                   ]
                                                 }
                                               ],
                                               "total": {
                                                 "itemsPrice": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 },
                                                 "otherFees": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 },
                                                 "discount": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 },
                                                 "orderAmount": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 }
                                               },
                                               "payments": {
                                                 "prepaid": 0,
                                                 "pending": 0,
                                                 "methods": [
                                                   {
                                                     "value": 0,
                                                     "currency": "BRL",
                                                     "type": "PREPAID",
                                                     "method": "CREDIT",
                                                     "methodInfo": "string",
                                                     "changeFor": 0
                                                   }
                                                 ]
                                               },
                                               "customer": {
                                                 "id": "string",
                                                 "phone": {
                                                   "number": "string",
                                                   "extension": "string"
                                                 },
                                                 "documentNumber": "string",
                                                 "name": "string",
                                                 "ordersCountOnMerchant": 0
                                               },
                                               "schedule": {
                                                 "scheduledDateTimeStart": "2019-08-24T14:15:22Z",
                                                 "scheduledDateTimeEnd": "2019-08-24T14:15:22Z"
                                               },
                                               "delivery": {
                                                 "deliveredBy": "MERCHANT",
                                                 "deliveryAddress": {
                                                   "country": "BR",
                                                   "state": "BR-SP",
                                                   "city": "São Paulo",
                                                   "district": "Moema",
                                                   "street": "Plaza Avenue",
                                                   "number": "100",
                                                   "complement": "BL 02 AP 31",
                                                   "reference": "Yellow House",
                                                   "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                                   "postalCode": "20111-000",
                                                   "coordinates": {
                                                     "latitude": -23.54823,
                                                     "longitude": -46.63632
                                                   }
                                                 },
                                                 "estimatedDeliveryDateTime": "2019-08-24T14:15:22Z",
                                                 "deliveryDateTime": "2019-08-24T14:15:22Z"
                                               },
                                               "takeout": {
                                                 "mode": "DEFAULT",
                                                 "takeoutDateTime": "2019-08-24T14:15:22Z"
                                               },
                                               "indoor": {
                                                 "mode": "DEFAULT",
                                                 "indoorDateTime": "2019-08-24T14:15:22Z",
                                                 "place": "string"
                                               },
                                               "extraInfo": "string"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping(value = "{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Order> getOrderDetails(@PathVariable UUID orderId) throws Exception;

    @Operation(summary = "Save a new order.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the order is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                               "id": "string",
                                               "type": "DELIVERY",
                                               "displayId": "string",
                                               "sourceAppId": "string",
                                               "createdAt": "2019-08-24T14:15:22Z",
                                               "orderTiming": "INSTANT",
                                               "preparationStartDateTime": "2019-08-24T14:15:22Z",
                                               "merchant": {
                                                 "id": "22815773000169-dbc7e35a-c936-4665-9e13-eb55eb8b6824",
                                                 "name": "Pizza Plaza"
                                               },
                                               "items": [
                                                 {
                                                   "id": "string",
                                                   "index": 0,
                                                   "name": "string",
                                                   "externalCode": "string",
                                                   "unit": "UNIT",
                                                   "ean": "string",
                                                   "quantity": 0,
                                                   "specialInstructions": "string",
                                                   "unitPrice": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "optionsPrice": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "totalPrice": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "options": [
                                                     {
                                                       "index": 0,
                                                       "id": "string",
                                                       "name": "string",
                                                       "externalCode": "string",
                                                       "unit": "string",
                                                       "ean": "string",
                                                       "quantity": 0,
                                                       "unitPrice": {
                                                         "value": 40,
                                                         "currency": "BRL"
                                                       },
                                                       "totalPrice": {
                                                         "value": 40,
                                                         "currency": "BRL"
                                                       },
                                                       "specialInstructions": "string"
                                                     }
                                                   ]
                                                 }
                                               ],
                                               "otherFees": [
                                                 {
                                                   "name": "string",
                                                   "type": "DELIVERY_FEE",
                                                   "receivedBy": "MARKETPLACE",
                                                   "receiverDocument": "string",
                                                   "price": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "observation": "string"
                                                 }
                                               ],
                                               "discounts": [
                                                 {
                                                   "amount": {
                                                     "value": 40,
                                                     "currency": "BRL"
                                                   },
                                                   "target": "CART",
                                                   "targetId": "string",
                                                   "sponsorshipValues": [
                                                     {
                                                       "name": "MARKETPLACE",
                                                       "amount": {
                                                         "value": 40,
                                                         "currency": "BRL"
                                                       }
                                                     }
                                                   ]
                                                 }
                                               ],
                                               "total": {
                                                 "itemsPrice": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 },
                                                 "otherFees": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 },
                                                 "discount": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 },
                                                 "orderAmount": {
                                                   "value": 40,
                                                   "currency": "BRL"
                                                 }
                                               },
                                               "payments": {
                                                 "prepaid": 0,
                                                 "pending": 0,
                                                 "methods": [
                                                   {
                                                     "value": 0,
                                                     "currency": "BRL",
                                                     "type": "PREPAID",
                                                     "method": "CREDIT",
                                                     "methodInfo": "string",
                                                     "changeFor": 0
                                                   }
                                                 ]
                                               },
                                               "customer": {
                                                 "id": "string",
                                                 "phone": {
                                                   "number": "string",
                                                   "extension": "string"
                                                 },
                                                 "documentNumber": "string",
                                                 "name": "string",
                                                 "ordersCountOnMerchant": 0
                                               },
                                               "schedule": {
                                                 "scheduledDateTimeStart": "2019-08-24T14:15:22Z",
                                                 "scheduledDateTimeEnd": "2019-08-24T14:15:22Z"
                                               },
                                               "delivery": {
                                                 "deliveredBy": "MERCHANT",
                                                 "deliveryAddress": {
                                                   "country": "BR",
                                                   "state": "BR-SP",
                                                   "city": "São Paulo",
                                                   "district": "Moema",
                                                   "street": "Plaza Avenue",
                                                   "number": "100",
                                                   "complement": "BL 02 AP 31",
                                                   "reference": "Yellow House",
                                                   "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                                   "postalCode": "20111-000",
                                                   "coordinates": {
                                                     "latitude": -23.54823,
                                                     "longitude": -46.63632
                                                   }
                                                 },
                                                 "estimatedDeliveryDateTime": "2019-08-24T14:15:22Z",
                                                 "deliveryDateTime": "2019-08-24T14:15:22Z"
                                               },
                                               "takeout": {
                                                 "mode": "DEFAULT",
                                                 "takeoutDateTime": "2019-08-24T14:15:22Z"
                                               },
                                               "indoor": {
                                                 "mode": "DEFAULT",
                                                 "indoorDateTime": "2019-08-24T14:15:22Z",
                                                 "place": "string"
                                               },
                                               "extraInfo": "string"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "If you don't have authorization.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Data to save a new order.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "id": "string",
                                      "type": "DELIVERY",
                                      "displayId": "string",
                                      "sourceAppId": "string",
                                      "createdAt": "2019-08-24T14:15:22Z",
                                      "orderTiming": "INSTANT",
                                      "preparationStartDateTime": "2019-08-24T14:15:22Z",
                                      "merchant": {
                                        "id": "22815773000169-dbc7e35a-c936-4665-9e13-eb55eb8b6824",
                                        "name": "Pizza Plaza"
                                      },
                                      "items": [
                                        {
                                          "id": "string",
                                          "index": 0,
                                          "name": "string",
                                          "externalCode": "string",
                                          "unit": "UNIT",
                                          "ean": "string",
                                          "quantity": 0,
                                          "specialInstructions": "string",
                                          "unitPrice": {
                                            "value": 40,
                                            "currency": "BRL"
                                          },
                                          "optionsPrice": {
                                            "value": 40,
                                            "currency": "BRL"
                                          },
                                          "totalPrice": {
                                            "value": 40,
                                            "currency": "BRL"
                                          },
                                          "options": [
                                            {
                                              "index": 0,
                                              "id": "string",
                                              "name": "string",
                                              "externalCode": "string",
                                              "unit": "string",
                                              "ean": "string",
                                              "quantity": 0,
                                              "unitPrice": {
                                                "value": 40,
                                                "currency": "BRL"
                                              },
                                              "totalPrice": {
                                                "value": 40,
                                                "currency": "BRL"
                                              },
                                              "specialInstructions": "string"
                                            }
                                          ]
                                        }
                                      ],
                                      "otherFees": [
                                        {
                                          "name": "string",
                                          "type": "DELIVERY_FEE",
                                          "receivedBy": "MARKETPLACE",
                                          "receiverDocument": "string",
                                          "price": {
                                            "value": 40,
                                            "currency": "BRL"
                                          },
                                          "observation": "string"
                                        }
                                      ],
                                      "discounts": [
                                        {
                                          "amount": {
                                            "value": 40,
                                            "currency": "BRL"
                                          },
                                          "target": "CART",
                                          "targetId": "string",
                                          "sponsorshipValues": [
                                            {
                                              "name": "MARKETPLACE",
                                              "amount": {
                                                "value": 40,
                                                "currency": "BRL"
                                              }
                                            }
                                          ]
                                        }
                                      ],
                                      "total": {
                                        "itemsPrice": {
                                          "value": 40,
                                          "currency": "BRL"
                                        },
                                        "otherFees": {
                                          "value": 40,
                                          "currency": "BRL"
                                        },
                                        "discount": {
                                          "value": 40,
                                          "currency": "BRL"
                                        },
                                        "orderAmount": {
                                          "value": 40,
                                          "currency": "BRL"
                                        }
                                      },
                                      "payments": {
                                        "prepaid": 0,
                                        "pending": 0,
                                        "methods": [
                                          {
                                            "value": 0,
                                            "currency": "BRL",
                                            "type": "PREPAID",
                                            "method": "CREDIT",
                                            "methodInfo": "string",
                                            "changeFor": 0
                                          }
                                        ]
                                      },
                                      "customer": {
                                        "id": "string",
                                        "phone": {
                                          "number": "string",
                                          "extension": "string"
                                        },
                                        "documentNumber": "string",
                                        "name": "string",
                                        "ordersCountOnMerchant": 0
                                      },
                                      "schedule": {
                                        "scheduledDateTimeStart": "2019-08-24T14:15:22Z",
                                        "scheduledDateTimeEnd": "2019-08-24T14:15:22Z"
                                      },
                                      "delivery": {
                                        "deliveredBy": "MERCHANT",
                                        "deliveryAddress": {
                                          "country": "BR",
                                          "state": "BR-SP",
                                          "city": "São Paulo",
                                          "district": "Moema",
                                          "street": "Plaza Avenue",
                                          "number": "100",
                                          "complement": "BL 02 AP 31",
                                          "reference": "Yellow House",
                                          "formattedAddress": "Plaza Avenue, 100, BL 02 AP 31, Moema - São Paulo, SP - Brazil",
                                          "postalCode": "20111-000",
                                          "coordinates": {
                                            "latitude": -23.54823,
                                            "longitude": -46.63632
                                          }
                                        },
                                        "estimatedDeliveryDateTime": "2019-08-24T14:15:22Z",
                                        "deliveryDateTime": "2019-08-24T14:15:22Z"
                                      },
                                      "takeout": {
                                        "mode": "DEFAULT",
                                        "takeoutDateTime": "2019-08-24T14:15:22Z"
                                      },
                                      "indoor": {
                                        "mode": "DEFAULT",
                                        "indoorDateTime": "2019-08-24T14:15:22Z",
                                        "place": "string"
                                      },
                                      "extraInfo": "string"
                                    }
                                    """
                    )
            )
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Order> save(@RequestBody final Order order) throws Exception;

    @Operation(summary = "Confirms receipt of order.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "reason": "string",
                                              "createdAt": "2019-08-24T14:15:22Z",
                                              "orderExternalCode": "string"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Server understands the content type of the request entity, and the syntax of the request entity is correct, but it was unable to process the contained instructions. (Check that the instruction has not been sent before.)",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 422
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PutMapping(value = "/{orderId}/confirm", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderConfirmVO> confirm(@PathVariable UUID orderId, @RequestBody OrderConfirmVO orderConfirm);

    @Operation(summary = "Confirms receipt of order.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "reason": "string",
                                              "createdAt": "2019-08-24T14:15:22Z",
                                              "orderExternalCode": "string"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Server understands the content type of the request entity, and the syntax of the request entity is correct, but it was unable to process the contained instructions. (Check that the instruction has not been sent before.)",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 422
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PostMapping(value = "/{orderId}/confirm", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderConfirmVO> confirm2(@PathVariable UUID orderId, @org.springframework.web.bind.annotation.RequestBody(required = false) OrderConfirmVO orderConfirm);

    @Operation(summary = "Informs you that the order is ready for pickup.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Server understands the content type of the request entity, and the syntax of the request entity is correct, but it was unable to process the contained instructions. (Check that the instruction has not been sent before.)",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 422
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PutMapping(value = "/{orderId}/readyForPickup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Event> readyForPickup(@PathVariable UUID orderId);

    @Operation(summary = "Informs you that the order is ready for pickup.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Server understands the content type of the request entity, and the syntax of the request entity is correct, but it was unable to process the contained instructions. (Check that the instruction has not been sent before.)",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 422
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PostMapping(value = "/{orderId}/readyForPickup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Event> readyForPickup2(@PathVariable UUID orderId);

    @Operation(summary = "Dispatch an Order.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Server understands the content type of the request entity, and the syntax of the request entity is correct, but it was unable to process the contained instructions. (Check that the instruction has not been sent before.)",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 422
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PutMapping(value = "/{orderId}/dispatch", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Event> dispatch(@PathVariable UUID orderId);

    @Operation(summary = "Dispatch an Order.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Server understands the content type of the request entity, and the syntax of the request entity is correct, but it was unable to process the contained instructions. (Check that the instruction has not been sent before.)",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 422
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PostMapping(value = "/{orderId}/dispatch", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Event> dispatch2(@PathVariable UUID orderId);

}