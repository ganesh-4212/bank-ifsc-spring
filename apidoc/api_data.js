define({ "api": [
  {
    "version": "1.0.0",
    "type": "get",
    "url": "/branches",
    "title": "Get All Bank branch details (Paginated).",
    "name": "GetByBankNameAndCity",
    "group": "Bank_Details",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "bankName",
            "description": "<p>Bank name.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "city",
            "description": "<p>Bank branch city.</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "page",
            "description": "<p>Pagination page index (Zero based).</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "size",
            "description": "<p>Number of records per request.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object[]",
            "optional": false,
            "field": "BankDetailsDto",
            "description": "<p>Bank branch details.</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "BankDetailsDto.id",
            "description": "<p>Bank id.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.name",
            "description": "<p>Bank name.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.ifsc",
            "description": "<p>Bank branch ifsc code.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.branch",
            "description": "<p>Bank branch name.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.address",
            "description": "<p>Bank branch address.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.city",
            "description": "<p>Bank branch city.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.district",
            "description": "<p>Bank branch district.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.state",
            "description": "<p>Bank branch state.</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/ganesh/bankifsc/controller/BankDetailsController.java",
    "groupTitle": "Bank_Details"
  },
  {
    "version": "1.0.0",
    "type": "get",
    "url": "/branches/:ifscCode",
    "title": "Get Bank details by IFSC code.",
    "name": "GetByIFSCCode",
    "group": "Bank_Details",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "ifscCode",
            "description": "<p>Bank Branch IFSC code.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "BankDetailsDto",
            "description": "<p>Bank branch details.</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "BankDetailsDto.id",
            "description": "<p>Bank id.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.name",
            "description": "<p>Bank name.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.ifsc",
            "description": "<p>Bank branch ifsc code.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.branch",
            "description": "<p>Bank branch name.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.address",
            "description": "<p>Bank branch address.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.city",
            "description": "<p>Bank branch city.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.district",
            "description": "<p>Bank branch district.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "BankDetailsDto.state",
            "description": "<p>Bank branch state.</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/ganesh/bankifsc/controller/BankDetailsController.java",
    "groupTitle": "Bank_Details"
  }
] });
