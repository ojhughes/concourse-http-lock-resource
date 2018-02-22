INSERT INTO public.environment_meta_schema (schema, id) VALUES ('{
  "$id": "http://example.com/example.json",
  "type": "object",
  "definitions": {},
  "$schema": "http://json-schema.org/draft-07/schema#",
  "properties": {
    "trustCerts": {
      "$id": "/properties/trustCerts",
      "type": "boolean"
    },
    "boshDeploymentManifest": {
      "$id": "/properties/boshDeploymentManifest",
      "type": "string"
    },
    "apiHost": {
      "$id": "/properties/apiHost",
      "type": "string"
    },
    "appsDomain": {
      "$id": "/properties/appsDomain",
      "type": "string"
    },
    "pcfHost": {
      "$id": "/properties/pcfHost",
      "type": "string"
    }
  }
}', 1);