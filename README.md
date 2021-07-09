## Micronaut 2.5.6 Documentation

- [User Guide](https://docs.micronaut.io/2.5.6/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.6/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.6/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Deployment with GraalVM

If you want to deploy to AWS Lambda as a GraalVM native image, run:

```bash
./gradlew buildNativeLambda -Pmicronaut.runtime=lambda
```

This will build the GraalVM native image inside a docker container and generate the `function.zip` ready for the deployment.

## Handler

[AWS Lambda Handler](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)

Handler: crypto.BookRequestHandler

## Feature mockito documentation

- [https://site.mockito.org](https://site.mockito.org)

## Feature aws-lambda-custom-runtime documentation

- [Micronaut Custom AWS Lambda runtime documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambdaCustomRuntimes)

- [https://docs.aws.amazon.com/lambda/latest/dg/runtimes-custom.html](https://docs.aws.amazon.com/lambda/latest/dg/runtimes-custom.html)

## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)

## Feature aws-lambda documentation

- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

----------------------------

```
https://sdkman.io/install

https://micronaut-projects.github.io/micronaut-starter/latest/guide/#installation

https://blog.formkiq.com/tutorials/aws-lambda-graalvm
https://9oelm.github.io/2021-03-13-complete-end-to-end-guide-for-developing-dockerized-lambda-with-typescript-terraform-and-SAM-cli/

graalvm,lombok,mockito,aws-lambda
openapi
aws-lambda
netty-server
graphql
properties
graphql

./gradlew buildNativeLambda -Pmicronaut.runtime=lambda
cd terraform/local
terraform apply -auto-approve
// May need twice

https://github.localstack/com/localstack
# https://javadoc.io/static/com.amazonaws/aws-lambda-java-events/2.2.7/com/amazonaws/services/lambda/runtime/events/APIGatewayProxyRequestEvent.html
aws lambda invoke --region=us-east-1 --endpoint-url=http://localhost:4566 --function-name=crypto_lambda --payload '{"body":"{\"action\":\"ENCRYPT\",\"data\":\"Hello World\"}"}' response.json
cat response.json
cat response.json | jq -r .body
cat response.json | jq -r .errorMessage


terraform apply

crypto_api_id = "e17e8i0q62"
crypto_api_path = "/crypto"



aws lambda list-functions --region=us-east-1 --endpoint-url=http://localhost:4566

aws lambda invoke --region=us-east-1 --function-name=crypto_lambda --endpoint-url=http://localhost:4566 output.txt



aws apigateway get-rest-apis --region us-east-1 --endpoint-url=http://localhost:4566

aws apigateway get-resources --region us-east-1 --rest-api-id c79x2hub0o --endpoint-url=http://localhost:4566

curl http://localhost:4566/restapis/e17e8i0q62/test/_user_request_/crypto -H 'Content-Type: application/json' -d '{"action":"ENCRYPT","data":"Hello World"}'


aws --endpoint-url=http://localhost:4566 logs describe-log-groups
aws --endpoint-url=http://localhost:4566 logs describe-log-streams --log-group-name /aws/lambda/crypto_lambda
aws --endpoint-url=http://localhost:4566 logs get-log-events --log-group-name /aws/lambda/crypto_lambda --log-stream-name 2021/07/07/[LATEST]9ca15c1d | jq -r .events[].message
aws --endpoint-url=http://localhost:4566 logs delete-log-group --log-group-name /aws/lambda/crypto_lambda
```