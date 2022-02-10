Authentication:

1. auth/register = expects format {"username":"", "password":"" , email :""}
2. on successful auth returns jwt, format {"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlY2hvMSIsImV4cCI6MTYzMDQxODYxMCwiaWF0IjoxNjMwNDAwNjEwfQ.
                                                    OxSXZD-bL6uCXRanPSj5BdjL-2WmwFQ3TtGD9DprkucQG_KF8ZLRi3Vs0HmlZlsJNRQC-M7mbTuqs2kr35uyfA"}

3. token is expected starting with Bearer,
   Expected format = Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlY2hvIiwiZXhwIjoxNjMwNDE1MDkwLCJpYXQiOjE2MzAzOTcwOTB9.
                                               YgCU5-zTcmCUuVivOK7JrD9-v_1UZPo1Lxo8qCew267iuzuUevOlOjOyisGUi8ymRgFm6GoAe_U-XXZd2khKrA

PvP Rank:
1. /api/v1/rank  = GET request, the interface RankCharData is the projection for the JPA for this API

Shop:
1. /api/v1/shop/products = GET Request, server responds with the list of products.
1. /api/v1/shop/products = POST Request, saves a product in db. example of request body
    {
        "name" : "level 30 Accessory",
        "category" : "accessories",
        "price" : 600,
        "description" : "Full access set",
        "image" :"top1.jpg",
        "productId": 10023
    }
                                                .
2. /api/v1/checkout = POST Request, expected format -> [{id:"", quantity:}, .....]
