# Beispielaufrufe
Können später als POstman Collection hinterlegt werden. TBD.

## /drivers

### POST

```json
{
  "firstName": "driver_test",
  "lastName": "driver_test",
  "email": "email_test",
  "phoneNumber": "0123456789"
}
```

### PUT

```json
{
  "firstName": "driver_test",
  "lastName": "driver_test",
  "email": "email_test",
  "phoneNumber": "0123456789"
}
```

## /customers

### POST

```json
{
  "name": "cust_test",
  "email": "mail_test",
  "address": "address_test",
  "city": "city_test",
  "postalCode": "postal_test",
  "country": "country_test"
}
```

### PUT

```json
{
  "name": "cust_test",
  "email": "mail_test",
  "address": "address_test",
  "city": "city_test",
  "postalCode": "postal_test",
  "country": "country_test"
}
```

## /invoices

### POST

```json
{
  "datum": "2022-06-25",
  "endBetrag": 450,
  "customerId": 1,
  "tripsIds": [
    1,
    2
  ]
}
```

### PUT

```json
{
  "datum": "2022-06-25",
  "endBetrag": 450,
  "customerId": 1,
  "tripsIds": [
    1,
    2
  ]
}
```

## /trips

### POST

```json
{
  "datum": "2022-06-29",
  "orderer": "orderer_test",
  "startAdress": "adress_test",
  "finishingPoint": "finishPint_test",
  "fahrzeugart": "bus",
  "entfernung": 400,
  "serviceZeit": 57,
  "nettoPreis": 560,
  "customerId": 1,
  "courierDriverId": 1
}
```

### PUT

```json
{
  "datum": "2022-06-29",
  "orderer": "orderer_test",
  "startAdress": "adress_test",
  "finishingPoint": "finishPint_test",
  "fahrzeugart": "bus",
  "entfernung": 400,
  "serviceZeit": 57,
  "nettoPreis": 560,
  "customerId": 1,
  "courierDriverId": 1
}
```