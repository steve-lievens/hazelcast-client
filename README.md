Hazelcast REST client
=====================
This project contains a microservice layer on top of Hazelcast IMDG using the Quarkus framework.

Highlevel steps to start from scratch:

1. Initiate a Quarkus project.

This project was created using this command :
(source : https://quarkus.io/guides/rest-json)

```
mvn io.quarkus:quarkus-maven-plugin:1.6.0.Final:create \
    -DprojectGroupId=com.ibm.demo \
    -DprojectArtifactId=hazelcast-client \
    -DclassName="com.ibm.demo.rest.json.SimpleKeyValue" \
    -Dpath="/simplekv" \
    -Dextensions="resteasy-jsonb"
```

The project is created in the folder "hazelcast-client".
If you want to try this, run :

```
cd hazelcast-client
./mvnw compile quarkus:dev
```

Maven created a java class, which is now returning plain text.
Let's switch to JSON.

2. Add the Hazelcast client

Open the pom.xml file and add this to the dependencies section :

```
<dependency>
    <groupId>com.hazelcast</groupId>
    <artifactId>quarkus-hazelcast-client</artifactId>
</dependency>
```

Create the HazelcastClientConfig class and the TransactionHC (and TransactionBean) class for testing (see repo).

As you can see there, the HazelcastClientConfig is using a property called HC_ADDRESS.
You can set this property to the IP address of the Hazelcast cluster.

If you look at what's in the repo, you'll see that the property is mapped to an environment variable called HAZELCAST_HOST. So, if you leave it like it is, you can also set this environment variable before you run the project. If the environment variable is not set, it will fall back to the second element in that property.
This is the internal DNS name of the Hazelcast cluster on my OpenShift cluster. The first part "hz-hazelcast-enterprise" is the actual name of the Service object, the second part is the Project (or namespace) where my cluster is running. You need this extra part if this application runs in a separate project in order to resolve. 

With this setup, I can run this code locally with the environment variable set and when I deploy to my cluster it will work without it.
Same applies for the map name, which is using the env variable HAZELCAST_MAPNAME and defaults to "private_public_map".
If you want a local environment variable to be always there, you can create a .env file in the root of the project and add the environment variables there as key/value pairs. Just don't push this file to git as it might include sensitive info.

Let's compile it again :

```
./mvnw compile quarkus:dev
```

You can now test with a tool like Postman to POST data to the REST endpoint.

In the Hazelcast management center, you can monitor which maps are being created and how many objects are there. You can even do a query on a key to see the contents of the object.

