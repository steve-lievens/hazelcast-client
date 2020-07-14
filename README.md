Hazelcast REST client
=====================
This project contains a microservice layer on top of Hazelcast IMDG using the Quarkus framework.

Highlevel steps :

1. Initiate a Quarkus project.

This project was created using this command :
(source : https://quarkus.io/guides/rest-json)

```
mvn io.quarkus:quarkus-maven-plugin:1.6.0.Final:create \
    -DprojectGroupId=com.ibm.demo \
    -DprojectArtifactId=hazelcast-service \
    -DclassName="com.ibm.demo.rest.json.SimpleKeyValue" \
    -Dpath="/simplekv" \
    -Dextensions="resteasy-jsonb"
```

The project is created in the folder "hazelcast-service".
If you want to try this, run :

```
cd hazelcast-service
./mvnw compile quarkus:dev
```

Maven created a java class, which is now returning plain text.
Let's switch to JSON.

2. Update the code in package com.ibm.demo.rest.json

Add the SimpleKeyValueBean and update the SimpleKeyValue class.
This will return JSON instead of simple text.
You can test it on http://localhost:8080/simplekv

3. Add the Hazelcast client

Open the pom.xml file and add this to the dependencies section :

```
<dependency>
    <groupId>com.hazelcast</groupId>
    <artifactId>quarkus-hazelcast-client</artifactId>
</dependency>
```

Create the HazelcastClientConfig class and the SimpleKeyValueHC class for testing (see repo)

And compile it again :

```
./mvnw compile quarkus:dev
```

You can now test with a tool like Postman to POST data to the REST endpoint.
In the Hazelcast management center, you can monitor which maps are being created and how many objects are there. You can even do a query on a key to see the contents of the object.
