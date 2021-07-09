resource "aws_lambda_permission" "crypto_lambda_permission" {
  statement_id  = "AllowExecutionFromAPIGateway"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.crypto_lambda.function_name
  principal     = "apigateway.amazonaws.com"

  # More: http://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
  source_arn = "arn:aws:execute-api:${var.region}:${var.accountId}:${aws_api_gateway_rest_api.crypto_api.id}/*/${aws_api_gateway_method.crypto_api_get.http_method}${aws_api_gateway_resource.crypto_api_resource.path}"
}

resource "aws_lambda_function" "crypto_lambda" {
  function_name    = "crypto_lambda"
  handler          = "crypto.BookRequestHandler::handleRequest"
  runtime          = "provided"
  filename         = "../../build/libs/crypto-0.1-lambda.zip"
  source_code_hash = filebase64sha256("../../build/libs/crypto-0.1-lambda.zip")
  role             = aws_iam_role.lambda_exec_role.arn
  environment {
    variables = {
      LOG_LEVEL = "DEBUG"
    }
  }
}
