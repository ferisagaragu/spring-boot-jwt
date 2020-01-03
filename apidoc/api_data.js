define({ "api": [
  {
    "group": "User",
    "version": "0.0.1",
    "description": "<p>Servicio para eliminar un usuario (eliminación lógica)</p>",
    "type": "delete",
    "url": "user/delete/:id",
    "title": "delete",
    "permission": [
      {
        "name": "{admin}"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "Id",
            "description": "<p>Identificador único</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"2020-01-03T18:41:46.305+0000\",\n\t\"status\": 200,\n\t\"message\": \"your success message\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T18:13:58.035+0000\",\n\t\"status\": 400,\n\t\"error\": \"Bad Request\",\n\t\"message\": \"your problem message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/delete/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 401 Unauthorized",
          "content": "{\n\t\"timestamp\": \"2020-01-03T04:17:06.006+0000\",\n\t\"status\": 401,\n\t\"error\": \"Unauthorized\",\n\t\"message\": \"Full authentication is required to access this resource\",\n\t\"path\": \"/user/delete/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/delete/:id\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/org/neurobrain/tlozbotw/controller/UserController.java",
    "groupTitle": "User",
    "name": "DeleteUserDeleteId"
  },
  {
    "group": "User",
    "version": "0.0.1",
    "description": "<p>Servicio para iniciar sesión por primera vez</p>",
    "type": "post",
    "url": "user/firstSignup/:id",
    "title": "firstSignup",
    "permission": [
      {
        "name": "{user} {admin}"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "Id",
            "description": "<p>Identificador único</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Body:",
          "content": "\t\t{\n \t\t\t\"password\": \"your password\"\n\t\t}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"2020-01-03T04:05:37.126+0000\",\n\t\"status\": 200,\n\t\"message\": \"your success message\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T16:42:13.727+0000\",\n\t\"status\": 400,\n\t\"error\": \"Bad Request\",\n\t\"message\": \"your problem message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/firstSignup/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 401 Unauthorized",
          "content": "{\n\t\"timestamp\": \"2020-01-03T04:17:06.006+0000\",\n\t\"status\": 401,\n\t\"error\": \"Unauthorized\",\n\t\"message\": \"Full authentication is required to access this resource\",\n\t\"path\": \"/user/firstSignup/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/firstSignup/:id\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/org/neurobrain/tlozbotw/controller/UserController.java",
    "groupTitle": "User",
    "name": "PostUserFirstsignupId"
  },
  {
    "group": "User",
    "version": "0.0.1",
    "description": "<p>Servicio para bloquear y desbloquear un usuario</p>",
    "type": "put",
    "url": "user/blocked/:id",
    "title": "blocked",
    "permission": [
      {
        "name": "{admin}"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "Id",
            "description": "<p>Identificador único</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Body:",
          "content": "{\n\t\"blocked\": true | false\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"2020-01-03T18:35:29.813+0000\",\n\t\"status\": 200,\n\t\"message\": \"your success message\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T18:13:58.035+0000\",\n\t\"status\": 400,\n\t\"error\": \"Bad Request\",\n\t\"message\": \"your problem message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/blocked/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 401 Unauthorized",
          "content": "{\n\t\"timestamp\": \"2020-01-03T04:17:06.006+0000\",\n\t\"status\": 401,\n\t\"error\": \"Unauthorized\",\n\t\"message\": \"Full authentication is required to access this resource\",\n\t\"path\": \"/user/blocked/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/blocked/:id\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/org/neurobrain/tlozbotw/controller/UserController.java",
    "groupTitle": "User",
    "name": "PutUserBlockedId"
  },
  {
    "group": "User",
    "version": "0.0.1",
    "description": "<p>Servicio para actualizar un usuario</p>",
    "type": "put",
    "url": "user/update/:id",
    "title": "update",
    "permission": [
      {
        "name": "{user} {admin}"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "Id",
            "description": "<p>Identificador único</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Body:",
          "content": "{\n\t\"name\": \"your name\",\n\t\"lastName\": \"your last name\",\n\t\"phoneNumber\": \"your phone number\",\n\t\"imageUrl\": \"your account photo\",\n\t\"userName\": \"your user name\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"2020-01-03T18:03:54.033+0000\",\n\t\"status\": 200,\n\t\"message\": \"your success message\",\n\t\"data\": {\n\t\t\"id\": identify id,\n\t\t\"name\": \"your name\",\n\t\t\"lastName\": \"your last name\",\n\t\t\"phoneNumber\": \"your phone number\",\n\t\t\"imageUrl\": \"your account photo\",\n\t\t\"userName\": \"your user name\",\n\t\t\"email\": \"your email\",\n\t\t\"roles\": [\n\t\t\t\"your role\"\n\t\t]\n\t}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T18:13:58.035+0000\",\n\t\"status\": 400,\n\t\"error\": \"Bad Request\",\n\t\"message\": \"your problem message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/update/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 401 Unauthorized",
          "content": "{\n\t\"timestamp\": \"2020-01-03T04:17:06.006+0000\",\n\t\"status\": 401,\n\t\"error\": \"Unauthorized\",\n\t\"message\": \"Full authentication is required to access this resource\",\n\t\"path\": \"/user/update/:id\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\",\n\t\"trace\": \"your trace catch\",\n\t\"path\": \"/user/update/:id\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/org/neurobrain/tlozbotw/controller/UserController.java",
    "groupTitle": "User",
    "name": "PutUserUpdateId"
  }
] });
